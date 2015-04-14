/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMedia;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;

/**
 *
 * @author Bryden
 */
public class CFacebook implements ISocial {

    private final FacebookClient facebookClient;
    private final String MY_ACCESS_TOKEN = "CAAUBiYobRNQBAN8uUTG9Fj515XVooKLZCZCLydsaauMsraTWGOeiVT5Nq75LozIB1ncCR0tCxfQDFRvkYqGFcOanDHONGOZCkjHXDyuiIWh8Xa1JxfWOeCYVdBzkDNp3X2sm7wpng8NNP8ZA58nZAtEveWM9QJDRcQMReW4wwzOszWxpyu7qa";

    public CFacebook() {
        facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
    }

    @Override
    public void postMessage(String pStrMessage) {
        facebookClient.publish("me/feed", FacebookType.class,
                Parameter.with("message", pStrMessage));
    }

}
