/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Haze;

import Dengue.CDengueFactory;
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
import org.json.XML;

/**
 *
 * @author Bryden
 */
public class CHazeManager {

    private static final ScheduledExecutorService objScheduler
            = Executors.newScheduledThreadPool(1);

    public static void schedulePolling() {
        final Runnable poller = () -> {
            loadHazeInfo();
        };

        objScheduler.scheduleAtFixedRate(poller, 0, 30, TimeUnit.MINUTES);
    }

    public static void loadHazeInfo() {

        String strOutput = "";

        try {
            strOutput = CNetworkFactory.createHazeRequest().sendRequest();
        } catch (IOException ex) {
        }

        if (strOutput.isEmpty()) {
            return;
        }

        JSONObject objJson = XML.toJSONObject(strOutput);



        StringBuilder objSB = new StringBuilder();

        objSB.append("[");

       /* for (CDengueCluster objCluster : lstCluster) {
            objSB.append(objCluster.toJSON());
            objSB.append(",");
        }*/

        objSB.deleteCharAt(objSB.lastIndexOf(","));

        objSB.append("]");

        sendInfoToCPU(objSB.toString(), 33010);

    }

    private static void sendInfoToCPU(String pStrJSON, int pIntPort) {

        new Thread(() -> {
            try (Socket client = new Socket(InetAddress.getLocalHost(), pIntPort)) {

                Writer objWriter = Channels.newWriter(Channels.newChannel(client.getOutputStream()), StandardCharsets.US_ASCII.name());
                objWriter.write(pStrJSON);
                objWriter.flush();

                client.shutdownOutput();

                try (Reader objReader = Channels.newReader(Channels.newChannel(client.getInputStream()), StandardCharsets.US_ASCII.name());
                        BufferedReader objOutReader = new BufferedReader(objReader)) {
                    System.out.println((char) objOutReader.read());

                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }).start();
    }
}
