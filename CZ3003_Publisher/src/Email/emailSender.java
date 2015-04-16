package Email;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class emailSender {

    public static final HashMap<Integer, ArrayList<MessageToSend>> messagesToSend = new HashMap<>();
    //maps the priority levels to the corresponding emails to be sent - within each priority level

    public static Session objSession;

    private static final String strEmail = "cz3003timecrisis@gmail.com";
    private static final String strPwd = "3003liuyang";

    private static final int intMaxPriority = 3;

    static {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");

        objSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(strEmail, strPwd);
                    }
                });

        for (int i = 1; i <= intMaxPriority; i++) {
            messagesToSend.put(i, new ArrayList<>());
        }
    }

    public static void getEmailsToBeSent(JSONArray jsonArrayOfMails) throws IOException, ParseException {

        for (Object jsonArrayOfMail : jsonArrayOfMails) {
            JSONObject jsonObject = (JSONObject) jsonArrayOfMail;

            String from = jsonObject.get("from").toString();
            String recipients = jsonObject.get("recipients").toString();
            String subject = jsonObject.get("subject").toString();
            String messageText = jsonObject.get("messageText").toString();
            int priority = Integer.parseInt(jsonObject.get("priority").toString());

            MessageToSend m = new MessageToSend(from, recipients, subject, messageText, priority);
            messagesToSend.get(priority).add(m);
        }

//        System.out.println(messagesToSend);
    }

    public static void dispatchEmail() {

        for (Integer intKey : messagesToSend.keySet()) {
            for (int j = 0; j < messagesToSend.get(intKey).size(); j++) {

                synchronized (messagesToSend) {
                    MessageToSend m = messagesToSend.get(intKey).get(j);
                    String from = m.from;
                    String recipients = m.recipients;
                    String subject = m.subject;
                    String messageText = m.messageText;
                    int priority = m.priority;
                    try {
                        sendEmail(from, recipients, subject, messageText, priority);

                        messagesToSend.get(intKey).remove(j);
                    } catch (MessagingException ex) {
                    }
                }

            }
        }

    }

    public static void sendEmail(String from, String recipients, String subject, String messageText, int priority) throws MessagingException {

        Message message = new MimeMessage(objSession);
        message.setFrom(new InternetAddress(from));

        //Need to test the line below for multiple recipients:
        //InternetAddress[] toAddresses={new InternetAddress(strRecipient)};
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(recipients));

        message.setSubject(subject);
        message.setText(messageText);

        Transport.send(message);

    }

}
