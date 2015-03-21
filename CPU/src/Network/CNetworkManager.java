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

}
