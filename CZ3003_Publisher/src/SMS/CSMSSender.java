/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMS;

import Enitity.CSMS;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.MessageFactory;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Bryden
 */
public class CSMSSender implements ISMSSender {

    private static final String ACCOUNT_SID = "AC69adf37a129d6cbb3f6cedb9636eac59";
    private static final String AUTH_TOKEN = "467fa3f729336e3bdea0fcffc4b76e45";

    private final TwilioRestClient objClient;
    private final MessageFactory objMsgFactory;

    public CSMSSender() {
        objClient = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        objMsgFactory = objClient.getAccount().getMessageFactory();
    }

    @Override
    public void sendSMS(CSMS pObjSMS) throws Exception {

        List<NameValuePair> params = new ArrayList<>();

        params.add(new BasicNameValuePair("From", pObjSMS.getFrom()));
        params.add(new BasicNameValuePair("Body", pObjSMS.getMsg()));

        for (String strTo : pObjSMS.getTo()) {

            params.add(new BasicNameValuePair("To", strTo));

            objMsgFactory.create(params);

            params.remove(params.size() - 1);
        }

    }

}
