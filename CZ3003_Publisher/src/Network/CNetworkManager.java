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
}
