/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notification;

import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author bcho002
 */
public class CNotificationManager {

    private static final HashMap<String, Date> hmNotifications = new HashMap<>();

    private CNotificationManager() {
    }

    static {
        notifiyPendingIncident();
        notifiyOngoingIncident();
        notifiyHaze();
        notifiyDengue();
    }

    public static final HashMap<String, Date> getNotifications() {
        return hmNotifications;
    }

    public static final void notifiyPendingIncident() {
        hmNotifications.put("Pending_Incident", new Date());
    }

    public static final void notifiyOngoingIncident() {
        hmNotifications.put("Ongoing_Incident", new Date());
    }

    public static final void notifiyHaze() {
        hmNotifications.put("Haze", new Date());
    }

    public static final void notifiyDengue() {
        hmNotifications.put("Dengue", new Date());
    }
}
