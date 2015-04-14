/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Enitity.CSMS;
import Manager.CSMSManager;
import SMS.CSMSFactory;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.Observable;
import java.util.Observer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Bryden
 */
public class CSMSHandler implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        Socket objSocket = (Socket) arg;

        int intSeq = -1;

        try {

            JSONParser jsonParser = new JSONParser();

            JSONObject objJSON = (JSONObject) jsonParser.parse(new InputStreamReader(objSocket.getInputStream()));

            int intTempSeq = Integer.parseInt(objJSON.get("id").toString());

            for (CSMS objSMS : CSMSManager.loadFromJson((JSONArray) objJSON.get("sms"))) {

                CSMSFactory.getSMSSender().sendSMS(objSMS);
            }

            intSeq = intTempSeq;

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
