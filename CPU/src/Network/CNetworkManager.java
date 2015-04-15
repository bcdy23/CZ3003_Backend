/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Network.DBProxy.CProxyHandler;
import Network.Dengue.CDengueHandler;
import Network.Haze.CHazeHandler;
import Network.Notification.CNotificationHandler;
import Settings.CSettingManager;
import java.io.IOException;

/**
 *
 * @author Bryden
 */
public class CNetworkManager {

    public static void createDefaultListener() {

        CSocket objDefaultSocket;

        try {
            objDefaultSocket = new CSocket(3003);
        } catch (IOException ex) {
            System.out.println("");
            return;
        }

        objDefaultSocket.addObserver(new CDefaultHandler());

        objDefaultSocket.run();

    }

    public static void createProxyListener() {

        CSocket objProxySocket;

        try {
            objProxySocket = new CSocket(CSettingManager.getIntSetting("Proxy_Port"));
        } catch (IOException ex) {
            System.out.println("");
            return;
        }

        objProxySocket.addObserver(new CProxyHandler());

        objProxySocket.run();

    }

    public static void createNotificationListener() {
        CSocket objProxySocket;

        try {
            objProxySocket = new CSocket(CSettingManager.getIntSetting("Notification_Port"));
        } catch (IOException ex) {
            System.out.println("");
            return;
        }

        objProxySocket.addObserver(new CNotificationHandler());

        objProxySocket.run();
    }

    public static void createDengueListener() {

        CSocket objDefaultSocket;

        try {
            objDefaultSocket = new CSocket(CSettingManager.getIntSetting("Dengue_Port"));
        } catch (IOException ex) {
            System.out.println(ex);
            return;
        }
        objDefaultSocket.addObserver(new CDengueHandler());

        objDefaultSocket.run();

    }

    public static void createHazeListener() {
        CSocket objDefaultSocket;

        try {
            objDefaultSocket = new CSocket(CSettingManager.getIntSetting("Haze_Port"));
        } catch (IOException ex) {
            System.out.println(ex);
            return;
        }
        objDefaultSocket.addObserver(new CHazeHandler());

        objDefaultSocket.run();
    }
}
