package Email;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TestingStuff {
	public static HashMap<Integer, ArrayList<MessageToSend>> messagesToSend = new HashMap<Integer, ArrayList<MessageToSend>>();
	public static JSONObject jsonObjectOverall;
	public static JSONObject jsonObject;
	public static JSONArray jsonArrayOfMails;
	
	public static void formTrialJsonObject() throws IOException{
		for (int i=1; i<=3; i++){
			messagesToSend.put(i, new ArrayList<MessageToSend>());
		}
		
		jsonArrayOfMails = new JSONArray();
		
		MessageToSend m = new MessageToSend("cz3003timecrisis@gmail.com", "akritivij18@gmail.com", "Subject", "Body text", 3);
		messagesToSend.get(3).add(m);
		m = new MessageToSend("cz3003timecrisis@gmail.com", "akritivij18@gmail.com", "Subject", "Body text", 1);
		messagesToSend.get(1).add(m);
		m = new MessageToSend("cz3003timecrisis@gmail.com", "akritivij18@gmail.com", "Subject", "Body text", 1);
		messagesToSend.get(1).add(m);
		
		jsonObject = new JSONObject();
		jsonObject.put("from",  "cz3003timecrisis@gmail.com");
		jsonObject.put("recipients",  "akritivij18@gmail.com");
		jsonObject.put("subject",  "Subject ");
		jsonObject.put("messageText",  "body here");
		jsonObject.put("priority",  3);
		
		jsonArrayOfMails.add(jsonObject);
	
		
		jsonObject = new JSONObject();
		jsonObject.put("from",  "cz3003timecrisis@gmail.com");
		jsonObject.put("recipients",  "akritivij18@gmail.com");
		jsonObject.put("subject",  "Subject ");
		jsonObject.put("messageText",  "body here");
		jsonObject.put("priority",  3);
		
		jsonArrayOfMails.add(jsonObject);
		
		jsonObject = new JSONObject();
		jsonObject.put("from",  "cz3003timecrisis@gmail.com");
		jsonObject.put("recipients",  "akritivij18@gmail.com");
		jsonObject.put("subject",  "Subject ");
		jsonObject.put("messageText",  "body here");
		jsonObject.put("priority",  1);
		
		jsonArrayOfMails.add(jsonObject);
		
		jsonObject= new JSONObject();
		jsonObject.put("messagesToBeSent", jsonArrayOfMails);
		
		System.out.println(jsonArrayOfMails.toJSONString());
		System.out.println(jsonObject.toJSONString());
		
		FileWriter file = new FileWriter("trialJson.txt");
        try {
            file.write(jsonObject.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            
 
        } catch (IOException e) {
            e.printStackTrace();
 
        } finally {
            file.flush();
            file.close();
        }
		
	}
}
