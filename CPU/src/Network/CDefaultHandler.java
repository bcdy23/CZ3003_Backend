/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Bryden
 */
public class CDefaultHandler implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        Socket objSocket = (Socket) arg;

        StringBuilder objSB = new StringBuilder();

        try {

            BufferedReader objReader = new BufferedReader(new InputStreamReader(objSocket.getInputStream()));
            
            objSB.append(objReader.readLine());

            for (int intCount = 0; intCount < objSB.length() / 2; intCount++) {

                char chrTemp = objSB.charAt(intCount);

                objSB.deleteCharAt(intCount);

                objSB.insert(intCount, objSB.charAt(objSB.length() - 1 - intCount));

                objSB.deleteCharAt(objSB.length() - 1 - intCount);
                objSB.insert(objSB.length() - intCount, chrTemp);

                System.out.println(objSB.toString());
                
            }
            

        } catch (IOException ex) {
            objSB.append("ERROR");
        }

        try (Writer objWriter = Channels.newWriter(Channels.newChannel(objSocket.getOutputStream()), StandardCharsets.US_ASCII.name())) {

            objWriter.write(objSB.toString());

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

}
