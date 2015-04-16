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
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

    private static final String strMailingList = "bcho002@e.ntu.edu.sg";

    //private static final String strMailingList = "brydencho91@hotmail.com,,";
    // private static final String strSMSList = "+6591544288;";
    private static final String strSMSList = "+6591544288";

    private static void sendToSocial(String pStrMsg) throws UnknownHostException {
        CPublisherFactory.getSocialPublisher().sendMessage(String.format(strSocialMsg, "%d", pStrMsg));
    }

    private static void sendToSMS(String pStrMsg) throws UnknownHostException {
        CPublisherFactory.getSMSPublisher().sendMessage(String.format(strSMSMsg, "%d", strSMSList, pStrMsg));
    }

    private static void sendToEmail(String pStrMsg, String pStrRecipients, String pStrSubj, int intPriority) throws UnknownHostException {
        CPublisherFactory.getEmailPublisher().sendMessage(String.format(strEmailMsg, "%d", pStrMsg, pStrRecipients, pStrSubj, intPriority));

    }

    private static void sendToReport(String pStrMsg) throws Exception {

        JSONParser jsonParser = new JSONParser();

        JSONObject objJSON = (JSONObject) jsonParser.parse(String.format(strReportMsg, "", pStrMsg));

        //int intTempSeq = Integer.parseInt(objJSON.get("id").toString());
        String strPath = CReport.genReport((JSONArray) objJSON.get("stats"));

        CPublisherFactory.getEmailPublisher().sendMessage(
                String.format(strEmailMsg, "%d", strPath, "c130152@e.ntu.edu.sg,bcho002@e.ntu.edu.sg", "Report", 1));

        // CPublisherFactory.getReportPublisher().sendMessage(String.format(strReportMsg, "%d", "c130152@e.ntu.edu.sg", pStrMsg));
    }

    public static void publishOngoingIncident(String pStrQuery) {

        String strMsg = "";

        if (pStrQuery.startsWith("UPDATE")) {

            int intId = Integer.parseInt(pStrQuery.trim().split("incidentID = ")[1].split(",")[0].trim());

            try {
                HashMap<String, String> objHM = new MIncident().loadIncidentInfo(intId);

                strMsg = String.format(CSettingManager.getSetting("Incident_Message"), objHM.get("Title"), objHM.get("Address"));

            } catch (SQLException ex) {
            }
        } else if (pStrQuery.startsWith("INSERT")) {

            String intId = pStrQuery.split("VALUES")[1].split(",")[2];

            String strTitle;
            try {
                strTitle = new MIncident().loadIncidentCategory(intId);

                strMsg = String.format(CSettingManager.getSetting("Incident_Message"),
                        strTitle, pStrQuery.split("VALUES")[1].split(",")[6].replaceAll("'", "").trim());
            } catch (SQLException ex) {
            }

        }

        try {
            CNotificationManager.notifiyOngoingIncident();

            sendToSocial(strMsg);
            sendToSMS(strMsg);

            sendToEmail(strMsg, strMailingList, "Incident Report", 1);

        } catch (UnknownHostException ex) {
        }

    }

    public static void publishHaze() {

        try {
            HashMap<String, String> objHM = new MHaze().getNationalPSIInfo();

            String strMsg = String.format(CSettingManager.getSetting("Haze_Message"), "%s", objHM.get("PSI"), objHM.get("Desc"));

            CNotificationManager.notifiyHaze();

            sendToSocial(strMsg);
            sendToSMS(strMsg);
            sendToEmail(strMsg, strMailingList, "Haze Report", 2);

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

            sendToEmail(strMsg, strMailingList, "Dengue Report", 2);

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
