/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

import Model.MDengue;
import Model.MHaze;
import Model.MIncident;
import Notification.CNotificationManager;
import Settings.CSettingManager;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Bryden
 */
public class CPublisherManager {

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

    private static void sendToSocial(String pStrMsg) throws UnknownHostException {
        CPublisherFactory.getSocialPublisher().sendMessage(String.format(strSocialMsg, "%d", pStrMsg));
    }

    private static void sendToSMS(String pStrMsg) throws UnknownHostException {
        CPublisherFactory.getSMSPublisher().sendMessage(String.format(strSMSMsg, "%d", "+6591544288", pStrMsg));
    }

    private static void sendToEmail(String pStrMsg, String pStrRecipients, String pStrSubj, int intPriority) throws UnknownHostException {
        CPublisherFactory.getEmailPublisher().sendMessage(String.format(strEmailMsg, "%d", pStrMsg, pStrRecipients, pStrSubj, intPriority));
    }

    public static void publishOngoingIncident(String pStrQuery) {

        int intId = Integer.parseInt(pStrQuery.trim().split("WHERE incidentID = ")[1]);

        try {
            HashMap<String, String> objHM = new MIncident().loadIncidentInfo(intId);

            String strMsg = String.format(CSettingManager.getSetting("Incident_Message"), objHM.get("Title"), objHM.get("Address"));

            CNotificationManager.notifiyOngoingIncident();

            sendToSocial(strMsg);
            sendToSMS(strMsg);

            sendToEmail(strMsg, "brydencho91@hotmail.com,bcho002@e.ntu.edu.sg", "Incident Report", 1);

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
            sendToEmail(strMsg, "brydencho91@hotmail.com,bcho002@e.ntu.edu.sg", "Haze Report", 2);

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

            sendToEmail(strMsg, "brydencho91@hotmail.com,bcho002@e.ntu.edu.sg", "Dengue Report", 2);

        } catch (SQLException | UnknownHostException ex) {
        }
    }

}
