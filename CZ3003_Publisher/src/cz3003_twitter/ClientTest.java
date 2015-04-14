package cz3003_twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bryden
 */
public class ClientTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int port = 33006;
        System.out.println("Connecting to local on port " + port);

        new Thread(() -> {
            try (Socket client = new Socket(InetAddress.getLocalHost(), port)) {
                System.out.println("Just connected to "
                        + client.getRemoteSocketAddress());

                Writer objWriter = Channels.newWriter(Channels.newChannel(client.getOutputStream()), StandardCharsets.US_ASCII.name());
                objWriter.write("[{\"id\": 1, \"message\":\"shoubi njkashdas\"}]");
                objWriter.flush();
                
                client.shutdownOutput();

                try (Reader objReader = Channels.newReader(Channels.newChannel(client.getInputStream()), StandardCharsets.US_ASCII.name());
                        BufferedReader objOutReader = new BufferedReader(objReader)) {
                    System.out.println(objOutReader.read());

                }

            } catch (IOException e) {
                System.out.println(e);
            }
        }).start();

    }
}
