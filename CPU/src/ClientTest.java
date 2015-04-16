
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
public class ClientTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Pattern regInsertIncident = Pattern.compile("INSERT INTO Incident [ (),\'a-zA-Z0-9]* VALUES [ (),\'a-zA-Z0-9]* 'On-going'");

        System.out.println(regInsertIncident.matcher("INSERT INTO Incident (incidentTitle, incidentDetails, incidentCategoryID, incidentStatus, latitude, longitude, address, staffID) VALUES ('lalal', 'dsdsad', 1, 'On-going', '1.3340347', '103.839307', 'Thomson Road Singapore', 3)").find());
        
        System.out.println("INSERT INTO Incident (incidentTitle, incidentDetails, incidentCategoryID, incidentStatus, latitude, longitude, address, staffID) VALUES ('lalal', 'dsda', 1, 'On-going', '1.3340347', '103.839307', 'Thomson Road Singapore', 3)".split("VALUES")[1].split(",")[2]);
    }
}
