/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import DataAccessLayer.Base.IDataStorage;
import Settings.CSettingManager;

/**
 *
 * @author SHOUBI
 */
public class CDataStorageFactory {

    private static final int intClusterSize = 2;

    private CDataStorageFactory() {

    }

    public static IDataStorage getDataStorage() {

        int intDB = (int) (Math.random() * intClusterSize);
        
        if (intDB == 0) {
            return new CMySQLDataStore(CSettingManager.getSetting("DB_Master_IP"), 3306);
        } else {
            return new CMySQLDataStore(CSettingManager.getSetting("DB_Slave_IP"), 3306);
        }
    }

    public static IDataStorage getMasterStorage() {

        return new CMySQLDataStore(CSettingManager.getSetting("DB_Master_IP"), 3306);

    }
}
