/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.Notification;

import Notification.CNotificationManager;
import java.io.Writer;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Bryden
 */
public class CNotificationHandler implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        Socket objSocket = (Socket) arg;

        StringBuilder objSB = new StringBuilder();

        HashMap<String, Date> hmNotifications = CNotificationManager.getNotifications();

        objSB.append("[");
        
        for (String strKey : hmNotifications.keySet()) {
        
            objSB.append("{");
            
            objSB.append("\"Event\" : \"");
            objSB.append(strKey);
            objSB.append("\",");
            
            objSB.append("\"DateTime\" : \"");
            objSB.append(hmNotifications.get(strKey));
            objSB.append("\"},");
        }

        objSB.deleteCharAt(objSB.lastIndexOf(","));
        
        objSB.append("]");
       
        try (Writer objWriter = Channels.newWriter(Channels.newChannel(objSocket.getOutputStream()), StandardCharsets.US_ASCII.name())) {

            objWriter.write(objSB.toString());

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}
