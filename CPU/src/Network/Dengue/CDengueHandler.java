/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.Dengue;

import Model.MDengue;
import Notification.CNotificationManager;
import Publisher.CPublisherManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.Observable;
import java.util.Observer;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryden
 */
public class CDengueHandler implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        int intReturn = 1;

        Socket objSocket = (Socket) arg;

        StringBuilder objSB = new StringBuilder();

        try {

            BufferedReader objReader = new BufferedReader(new InputStreamReader(objSocket.getInputStream()));

            objSB.append(objReader.readLine());

            new MDengue().addCluster(objSB.toString());

            CNotificationManager.notifiyDengue();
            CPublisherManager.publishDengue();
            
        } catch (IOException | ParseException ex) {
            System.out.println(ex);
            intReturn = -1;
        } finally {

            try (Writer objWriter = Channels.newWriter(Channels.newChannel(objSocket.getOutputStream()), StandardCharsets.US_ASCII.name())) {

                objWriter.append(intReturn + "");

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

}
