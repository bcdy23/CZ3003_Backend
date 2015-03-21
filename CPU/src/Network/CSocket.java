/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author Bryden
 */
public class CSocket extends Observable implements Runnable {

    private final ServerSocket objServerSocket;

    public CSocket() throws IOException {
        objServerSocket = CSocketFactory.createNetworkListener();
    }

    public CSocket(int intPortNumber) throws IOException {
        objServerSocket = CSocketFactory.createNetworkListener(intPortNumber);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket objSocket = objServerSocket.accept();

                this.setChanged();
                this.notifyObservers(objSocket);

            } catch (IOException ex) {
                System.out.println(ex);
            }

        }
    }

}
