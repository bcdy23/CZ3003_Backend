/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Bryden
 */
public class CSocketFactory {

    private CSocketFactory() {
    }

    public static ServerSocket createNetworkListener(int... pIntPortNumber) throws IOException {
        int intPort = pIntPortNumber.length > 0 ? pIntPortNumber[0] : 0;
        
        return new ServerSocket(intPort);
    }
}
