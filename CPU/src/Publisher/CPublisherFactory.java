/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Publisher;

import Settings.CSettingManager;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Bryden
 */
public class CPublisherFactory {

    public static CPublisher getSocialPublisher() throws UnknownHostException {
        return new CPublisher(InetAddress.getByName("127.0.0.1"), CSettingManager.getIntSetting("Social_Port"));
    }

    public static CPublisher getSMSPublisher() throws UnknownHostException {
        return new CPublisher(InetAddress.getByName("127.0.0.1"), CSettingManager.getIntSetting("SMS_Port"));
    }

    public static CPublisher getEmailPublisher() throws UnknownHostException {
        return new CPublisher(InetAddress.getByName("127.0.0.1"), CSettingManager.getIntSetting("Email_Port"));
    }

    public static CPublisher getReportPublisher() throws UnknownHostException {
        return new CPublisher(InetAddress.getByName("127.0.0.1"), CSettingManager.getIntSetting("Report_Port"));
    }
    

}
