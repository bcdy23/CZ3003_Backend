/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import SocialMedia.CSocialMediaFactory;
import java.io.IOException;
import java.io.Writer;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.Observable;
import java.util.Observer;
import javax.json.Json;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;

/**
 *
 * @author Bryden
 */
public class CSocialMediaHandler implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        Socket objSocket = (Socket) arg;

        int intSeq = -1;

        try {

            JsonParser objParser = Json.createParser(objSocket.getInputStream());

            int intTempSeq = -1;
            
            while (objParser.hasNext()) {
                Event objEvent = objParser.next();

                if (objEvent == Event.KEY_NAME) {
                    switch (objParser.getString()) {
                        case "message":

                            objParser.next();

                            String strMessage = objParser.getString();

                            System.out.println(strMessage);
                            
                            CSocialMediaFactory.getTwitter().postMessage(strMessage);
                            CSocialMediaFactory.getFacebook().postMessage(strMessage);

                            intSeq = intTempSeq;

                            break;
                        case "id":
                            objParser.next();

                            intTempSeq = objParser.getInt();
                            break;
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try (Writer objWriter = Channels.newWriter(Channels.newChannel(objSocket.getOutputStream()), StandardCharsets.US_ASCII.name())) {

                objWriter.write(intSeq + "");
                objWriter.flush();

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

}
