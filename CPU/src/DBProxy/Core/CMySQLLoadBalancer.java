/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBProxy.Core;

import Settings.CSettingManager;
import java.io.IOException;

/**
 *
 * @author Bryden
 */
public class CMySQLLoadBalancer {

    private static final int intClusterSize = 2;

    private CMySQLLoadBalancer() {

    }

    public static CMySQLSocket getDataStorage() {

        int intDB = (int) (Math.random() * intClusterSize);

        try {
            if (intDB == 0) {
                return getMasterStorage();
            } else {
                return new CMySQLSocket(CSettingManager.getSetting("DB_Slave_IP"), CSettingManager.getIntSetting("DB_Slave_Port"));
            }
        } catch (IOException ex) {
            
            return getDataStorage();
            
        }
    }

    public static CMySQLSocket getMasterStorage() throws IOException {

        return new CMySQLSocket(CSettingManager.getSetting("DB_Master_IP"), CSettingManager.getIntSetting("DB_Master_Port"));

    }
}
