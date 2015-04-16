/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Settings;

import File.CFileFactory;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Bryden
 */
public class CSettingManager {

    private static final Properties objProperties = new Properties();

    private static final String strPropertyPath = "setting/Settings.xml";

    private CSettingManager() {
    }

    static {
        try {
            objProperties.loadFromXML(CFileFactory.getFile_InputStream(strPropertyPath));
        } catch (IOException ex) {
            System.out.println("Unable to load properties file");
            System.out.println(ex);
            System.exit(0);
        }
    }

    public static Properties getPropertiesFile() {

        return objProperties;

    }

    public static void setSetting(String pStrKey, String pStrValue) {
        getPropertiesFile().setProperty(pStrKey, pStrValue);
    }

    public static String getSetting(String pStrName) {

        String strValue = getPropertiesFile().getProperty(pStrName);

        return strValue;
    }

    public static int getIntSetting(String pStrName) {

        return Integer.parseInt(getSetting(pStrName));
    }

}
