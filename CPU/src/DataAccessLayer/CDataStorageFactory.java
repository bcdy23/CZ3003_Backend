/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;
import DataAccessLayer.Base.IDataStorage;
import java.util.HashMap;

/**
 *
 * @author SHOUBI
 */
public class CDataStorageFactory {

    private static final HashMap<String, IDataStorage> hmDBServers = new HashMap<>();
   
    
    private CDataStorageFactory() {

    }

     static {
        if (hmDBServers.isEmpty()) {
            hmDBServers.put("MASTER", new CMySQLDataStore("127.0.0.1",3306,"cz3003Master","admin","cz3003_proxy"));
           // hmDBServers.put("SLAVE1", new CMySQLDataStore("172.22.218.155",3306,"cz3003Master","admin","cz3003master"));
        }
    }

    public static IDataStorage getDataStorage() {
        
            int intDB = (int) (Math.random() * hmDBServers.size());
                        
            return (IDataStorage) hmDBServers.values().toArray()[intDB];
        
    }

    public static IDataStorage getMasterStorage() {

        
        return hmDBServers.get("MASTER");

    }
}
