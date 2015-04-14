/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Bryden
 */
public class CUrlRequest {

    private final HttpURLConnection objConnection;
    private static final String strAgent = "Mozilla/5.0";

    public CUrlRequest(String pStrUrl) throws MalformedURLException, IOException {
        objConnection = (HttpURLConnection) new URL(pStrUrl).openConnection();

        objConnection.setRequestMethod("GET");
        objConnection.setRequestProperty("User-Agent", strAgent);

    }

    public String sendRequest() throws IOException {

        objConnection.connect();

        StringBuilder objSB = new StringBuilder();

        try (BufferedReader objReader = new BufferedReader(
                new InputStreamReader(objConnection.getInputStream()))) {

            String strLine;

            while ((strLine = objReader.readLine()) != null) {
                objSB.append(strLine);
            }
        }

        objConnection.disconnect();

        return objSB.toString();
        
    }

}
