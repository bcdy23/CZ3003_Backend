/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.IOException;

/**
 *
 * @author Bryden
 */
public class CNetworkManager {

    public static void createListener() {

        CSocket objDefaultSocket;

        try {
            objDefaultSocket = new CSocket(33006);
        } catch (IOException ex) {
            System.out.println("");
            return;
        }

        objDefaultSocket.addObserver(new CSocialMediaHandler());

        objDefaultSocket.run();

    }

    public static void createSMSListener() {

        CSocket objDefaultSocket;

        try {
            objDefaultSocket = new CSocket(33007);
        } catch (IOException ex) {
            System.out.println("");
            return;
        }

        objDefaultSocket.addObserver(new CSMSHandler());

        objDefaultSocket.run();

    }

    public static void createEmailListener() {

        CSocket objDefaultSocket;

        try {
            objDefaultSocket = new CSocket(33011);
        } catch (IOException ex) {
            System.out.println("");
            return;
        }

        objDefaultSocket.addObserver(new CEmailHandler());

        objDefaultSocket.run();

    }

    public static void createReportListener() {

        CSocket objDefaultSocket;

        try {
            objDefaultSocket = new CSocket(33012);
        } catch (IOException ex) {
            System.out.println(ex);
            return;
        }

        objDefaultSocket.addObserver(new CReportHandler());

        objDefaultSocket.run();

    }
}
