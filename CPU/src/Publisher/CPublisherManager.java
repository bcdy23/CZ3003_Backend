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

    private static final String strMsg = "[{\"id\": %s, \"message\":\"%s\"}]";

    private static void sendToSocial(String pStrMsg) throws UnknownHostException {

        CPublisherFactory.getSocialPublisher().sendMessage(String.format(strMsg, "%d", pStrMsg));

    }

    public static void publishOngoingIncident(String pStrQuery) {

        //"UPDATE Incident SET incidentStatus = 'On-going' , staffID = 3 WHERE incidentID = 22"
        int intId = Integer.parseInt(pStrQuery.trim().split("WHERE incidentID = ")[1]);

        try {
            HashMap<String, String> objHM = new MIncident().loadIncidentInfo(intId);

            String strMsg = String.format(CSettingManager.getSetting("Incident_Message"), objHM.get("Title"), objHM.get("Address"));

            CNotificationManager.notifiyOngoingIncident();

            sendToSocial(strMsg);

        } catch (SQLException | UnknownHostException ex) {
        }

    }

    public static void publishHaze() {

        try {
            HashMap<String, String> objHM = new MHaze().getNationalPSIInfo();

            String strMsg = String.format(CSettingManager.getSetting("Haze_Message"), objHM.get("PSI"), objHM.get("Desc"));

            CNotificationManager.notifiyHaze();

            sendToSocial(strMsg);

        } catch (SQLException | UnknownHostException ex) {
        }
    }
    
      public static void publishDengue() {

        try {
            HashMap<String, String> objHM = new MDengue().getDengueZoneInfo();

            String strMsg = String.format(CSettingManager.getSetting("Dengue_Message"), objHM.get("Red"), objHM.get("Yellow"));

            CNotificationManager.notifiyDengue();

            sendToSocial(strMsg);

        } catch (SQLException | UnknownHostException ex) {
        }
    }

}
