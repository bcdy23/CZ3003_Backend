/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

import Model.MDengue;
import Model.MHaze;
import Model.MIncident;
import Model.MStats;
import Notification.CNotificationManager;
import Settings.CSettingManager;
import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryden
 */
public class CPublisherManager {

    private static final ScheduledExecutorService objScheduler
            = Executors.newScheduledThreadPool(1);

    private static final String strSocialMsg = "[{\"id\": %s, \"message\":\"%s\"}]";

    private static final String strSMSMsg = "{"
            + "    \"id\": %s,\n"
            + "    \"sms\": [\n"
            + "        {\n"
            + "            \"from\": \"+1 484-870-3404\",\n"
            + "            \"to\": \"%s\",\n"
            + "            \"msg\": \"%s\"\n"
            + "        }\n"
            + "    ]\n"
            + "}";

    private static final String strEmailMsg = "{"
            + "    \"id\": %s,\n"
            + "    \"messagesToBeSent\": [\n"
            + "        {\n"
            + "            \"messageText\": \"%s\",\n"
            + "            \"recipients\": \"%s\",\n"
            + "            \"subject\": \"%s\",\n"
            + "            \"from\": \"cz3003timecrisis@gmail.com\",\n"
            + "            \"priority\": %d\n"
            + "        }\n"
            + "    ]\n"
            + "}";

    private static final String strReportMsg = "{"
            + "    \"id\": 1,\n"
            + "    \"email\": \"%s\",\n"
            + "    \"stats\": [\n"
            + "%s"
            + "    ]\n"
            + "}";

    private static void sendToSocial(String pStrMsg) throws UnknownHostException {
        CPublisherFactory.getSocialPublisher().sendMessage(String.format(strSocialMsg, "%d", pStrMsg));
    }

    private static void sendToSMS(String pStrMsg) throws UnknownHostException {
        CPublisherFactory.getSMSPublisher().sendMessage(String.format(strSMSMsg, "%d", "+6591544288;+6598733453", pStrMsg));
    }

    private static void sendToEmail(String pStrMsg, String pStrRecipients, String pStrSubj, int intPriority) throws UnknownHostException {
        CPublisherFactory.getEmailPublisher().sendMessage(String.format(strEmailMsg, "%d", pStrMsg, pStrRecipients, pStrSubj, intPriority));

    }

    private static void sendToReport(String pStrMsg) throws Exception {

        JSONParser jsonParser = new JSONParser();

        JSONObject objJSON = (JSONObject) jsonParser.parse(String.format(strReportMsg, "c130152@e.ntu.edu.sg,bcho002@e.ntu.edu.sg,benj0017@e.ntu.edu.sg", pStrMsg));

        //int intTempSeq = Integer.parseInt(objJSON.get("id").toString());
        String strPath = CReport.genReport((JSONArray) objJSON.get("stats"));

     //   CPublisherFactory.getEmailPublisher().sendMessage(
        //          String.format(strEmailMsg, "%d", strPath, "c130152@e.ntu.edu.sg,bcho002@e.ntu.edu.sg,benj0017@e.ntu.edu.sg", "Report", 1));
        // CPublisherFactory.getReportPublisher().sendMessage(String.format(strReportMsg, "%d", "c130152@e.ntu.edu.sg", pStrMsg));
    }

    public static void publishOngoingIncident(String pStrQuery) {

        int intId = Integer.parseInt(pStrQuery.trim().split("WHERE incidentID = ")[1]);

        try {
            HashMap<String, String> objHM = new MIncident().loadIncidentInfo(intId);

            String strMsg = String.format(CSettingManager.getSetting("Incident_Message"), objHM.get("Title"), objHM.get("Address"));

            CNotificationManager.notifiyOngoingIncident();

            sendToSocial(strMsg);
            sendToSMS(strMsg);

            sendToEmail(strMsg, "brydencho91@hotmail.com,benj0017@e.ntu.edu.sg,junyi.hjy@gmail.com", "Incident Report", 1);

        } catch (SQLException | UnknownHostException ex) {
        }

    }

    public static void publishHaze() {

        try {
            HashMap<String, String> objHM = new MHaze().getNationalPSIInfo();

            String strMsg = String.format(CSettingManager.getSetting("Haze_Message"), "%s", objHM.get("PSI"), objHM.get("Desc"));

            CNotificationManager.notifiyHaze();

            sendToSocial(strMsg);
            sendToSMS(strMsg);
            sendToEmail(strMsg, "brydencho91@hotmail.com,benj0017@e.ntu.edu.sg,junyi.hjy@gmail.com", "Haze Report", 2);

        } catch (SQLException | UnknownHostException ex) {
        }
    }

    public static void publishDengue() {

        try {
            HashMap<String, String> objHM = new MDengue().getDengueZoneInfo();

            String strMsg = String.format(CSettingManager.getSetting("Dengue_Message"), "%s", objHM.get("Red"), objHM.get("Yellow"));

            CNotificationManager.notifiyDengue();

            sendToSocial(strMsg);
            sendToSMS(strMsg);

            sendToEmail(strMsg, "brydencho91@hotmail.com,benj0017@e.ntu.edu.sg,junyi.hjy@gmail.com", "Dengue Report", 2);

        } catch (SQLException | UnknownHostException ex) {
        }
    }

    public static void publishReport() {
        try {

            String strMsg = new MStats().getStats();

            sendToReport(strMsg);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void createReportSender() {
        final Runnable poller = () -> {
            publishReport();
        };

        objScheduler.scheduleAtFixedRate(poller, 0, 30, TimeUnit.MINUTES);
    }

}
