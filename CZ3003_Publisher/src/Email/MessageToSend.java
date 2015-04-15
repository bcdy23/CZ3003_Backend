package Email;

public class MessageToSend {

    String from = "";
    String recipients = "";
    String subject = "";
    String messageText = "";
    int priority;

    public MessageToSend(String from, String recipients, String subject, String messageText, int priority) {
        this.from = from;
        this.recipients = recipients;
        this.subject = subject;
        this.messageText = messageText;
        this.priority = priority;
    }
}
