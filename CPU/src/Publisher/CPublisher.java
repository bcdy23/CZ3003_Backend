/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Bryden
 */
public class CPublisher {

    private static final int Max_Buffer = 512;

    private final InetAddress objAdd;
    private final int intPort;

    String[] strBuffer = new String[Max_Buffer];

    int intId = 0;

    public CPublisher(InetAddress pObjAdd, int pIntPort) {
        objAdd = pObjAdd;
        intPort = pIntPort;
    }

    public void sendMessage(String pStrMessage) {

        int intTemp;

        synchronized (this) {
            strBuffer[intId] = pStrMessage;
            intTemp = intId++;
        }

        new Thread(() -> {
            try (Socket client = new Socket(objAdd, intPort)) {

                Writer objWriter = Channels.newWriter(Channels.newChannel(client.getOutputStream()), StandardCharsets.US_ASCII.name());

                objWriter.write(String.format(pStrMessage, intTemp));
                objWriter.flush();

                client.shutdownOutput();

                try (Reader objReader = Channels.newReader(Channels.newChannel(client.getInputStream()), StandardCharsets.US_ASCII.name());
                        BufferedReader objOutReader = new BufferedReader(objReader)) {
                    //System.out.println(objOutReader.read());

                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }).start();
    }

}
