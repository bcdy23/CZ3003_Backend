/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz3003_twitter;

import Network.CNetworkManager;

/**
 *
 * @author SHOUBI
 */
public class CZ3003_Twitter {

    public static void main(String[] args) {

        new Thread(() -> {
            CNetworkManager.createListener();
        }).start();

        new Thread(() -> {
            CNetworkManager.createSMSListener();
        }).start();

        new Thread(() -> {
            CNetworkManager.createEmailListener();
        }).start();

        new Thread(() -> {
//            CNetworkManager.createReportListener();
        }).start();

    }
}
