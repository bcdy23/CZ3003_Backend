/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dengue;

import Entity.CDengueCluster;
import Network.CNetworkFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Bryden
 */
public class CDengueManager {

    private static final ScheduledExecutorService objScheduler
            = Executors.newScheduledThreadPool(1);

    public static void schedulePolling() {
        final Runnable poller = () -> {
            loadDengueCluster();
        };

        objScheduler.scheduleAtFixedRate(poller, 0, 30, TimeUnit.MINUTES);
    }

    public static void loadDengueCluster() {

        List<CDengueCluster> lstCluster = new ArrayList<>();

        String strJson = "";

        try {
            strJson = CNetworkFactory.createDengueClusterRequest().sendRequest();
        } catch (IOException ex) {
        }

        if (strJson.isEmpty()) {
            return;
        }

        JSONArray objArray = new JSONObject(strJson).getJSONArray("SrchResults");

        int intCount = objArray.getJSONObject(0).getInt("FeatCount");

        for (int intCounter = 1; intCounter <= intCount; intCounter++) {
            lstCluster.add(CDengueFactory.loadCluster(objArray.getJSONObject(intCounter)));
        }

        StringBuilder objSB = new StringBuilder();

        objSB.append("[");

        for (CDengueCluster objCluster : lstCluster) {
            objSB.append(objCluster.toJSON());
            objSB.append(",");
        }

        objSB.deleteCharAt(objSB.lastIndexOf(","));

        objSB.append("]");

        sendInfoToCPU(objSB.toString());

    }

    private static void sendInfoToCPU(String pStrJSON) {
        int port = 33009;
        System.out.println("Connecting to local on port " + port);

        new Thread(() -> {
            try (Socket client = new Socket(InetAddress.getLocalHost(), port)) {
                System.out.println("Just connected to "
                        + client.getRemoteSocketAddress());

                Writer objWriter = Channels.newWriter(Channels.newChannel(client.getOutputStream()), StandardCharsets.US_ASCII.name());
                objWriter.write(pStrJSON);
                objWriter.flush();

                client.shutdownOutput();

                try (Reader objReader = Channels.newReader(Channels.newChannel(client.getInputStream()), StandardCharsets.US_ASCII.name());
                        BufferedReader objOutReader = new BufferedReader(objReader)) {
                    System.out.println((char)objOutReader.read());

                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }).start();
    }

}
