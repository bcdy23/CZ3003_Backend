/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CZ3003_Subscriber;

import Network.CNetworkFactory;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

/**
 *
 * @author Bryden
 */
public class testXMLtoJSON {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        JSONArray aryRegions = XML.toJSONObject(
                CNetworkFactory.createHazeRequest().sendRequest()
        ).getJSONObject("channel")
                .getJSONObject("item")
                .getJSONArray("region");

        for (int i = 0; i < aryRegions.length(); i++) {

            JSONObject objRegion = (JSONObject) aryRegions.get(i);

            System.out.println(objRegion.getString("id"));

            JSONArray aryReadings = objRegion.getJSONObject("record").getJSONArray("reading");

            for (int x = 0; x < aryReadings.length(); x++) {

                JSONObject objReading = (JSONObject) aryReadings.get(x);

                if (objReading.getString("type").equalsIgnoreCase("NPSI")) {

                    System.out.println(objReading.getInt("value"));
                }

            }
        }

    }

}
