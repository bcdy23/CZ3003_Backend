
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.channels.Channels;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bryden
 */
public class ClientTest1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pattern regInsertIncident = Pattern.compile("UPDATE Incident [ (=),\'a-zA-Z0-9]* incidentStatus = 'On-going'");
        
        System.out.println(regInsertIncident.matcher("UPDATE Incident SET  incidentStatus = 'On-going', incidentID = 10 , dsadsd=1dsasds,").find());
        
        System.out.println(Integer.parseInt("UPDATE Incident SET  incidentStatus = 'On-going', incidentID = 10".trim().split("incidentID = ")[1].split(",")[0].trim()));
    }
}
