/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMedia;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author Bryden
 */
public class CTwitter implements ISocial {

    private Twitter objTwitter;

    public CTwitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("pHLUEo8VqYL1YJfXCwFoUumf2")
                .setOAuthConsumerSecret("7HWGZid7bNewVQjQbLt8MtSD8QLcBMOv8rfQ5Y6Bd8riIpkYf7")
                .setOAuthAccessToken("2855061284-40lddUpxDf46zlEZsiLMMekBU5r6L8dJFX3Lsfy")
                .setOAuthAccessTokenSecret("0TDs0JBRkA8CnY6YAavehMuvmuMRriM65BtTp6vptvNry");

        objTwitter = new TwitterFactory(cb.build()).getInstance();

    }

    @Override
    public void postMessage(String pStrMessage) throws Exception{
        objTwitter.updateStatus(pStrMessage);
    }

}
