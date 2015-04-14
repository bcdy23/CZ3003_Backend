
import Network.CNetworkManager;
import Publisher.CPublisherManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bryden
 */
public class CPU {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        new Thread(() -> {
            CNetworkManager.createNotificationListener();
        }).start();

        new Thread(() -> {
            CNetworkManager.createDengueListener();
        }).start();

        new Thread(() -> {
            CNetworkManager.createHazeListener();
        }).start();

        new Thread(() -> {
            CNetworkManager.createProxyListener();
        }).start();

        //CPublisherManager.publishHaze();

    }

}
