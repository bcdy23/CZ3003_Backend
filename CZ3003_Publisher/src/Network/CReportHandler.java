/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import Report.CReport;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.Observable;
import java.util.Observer;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryden
 */
public class CReportHandler implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        Socket objSocket = (Socket) arg;

        int intSeq = -1;

        try {

            
            System.out.println("dasdasdasdsa");
            
/*            JSONParser jsonParser = new JSONParser();

            JSONObject objJSON = (JSONObject) jsonParser.parse(new InputStreamReader(objSocket.getInputStream()));

            System.out.println(objJSON.toJSONString());

            int intTempSeq = Integer.parseInt(objJSON.get("id").toString());

            CReport.genReport((JSONArray) objJSON.get("stats"));

            intSeq = intTempSeq;*/

     //   } catch (IOException | ParseException | NumberFormatException | COSVisitorException ex) {
      //      System.out.println(ex);
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
