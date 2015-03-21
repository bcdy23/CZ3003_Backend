
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
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

        int port = 3003;
        System.out.println("Connecting to local on port " + port);

        try (Socket client = new Socket(InetAddress.getLocalHost(), port)) {
            System.out.println("Just connected to "
                    + client.getRemoteSocketAddress());

            try (Reader objReader = Channels.newReader(Channels.newChannel(client.getInputStream()), StandardCharsets.US_ASCII.name()); 
                    BufferedReader objOutReader = new BufferedReader(objReader)) {
                System.out.println(objOutReader.readLine());

            }

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}