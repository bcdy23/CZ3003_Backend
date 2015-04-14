/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataAccessLayer.Base.IDataStorage;
import DataAccessLayer.CDataStorageFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Bryden
 */
public class MDengue {

    public HashMap<String, String> getDengueZoneInfo() throws SQLException {
        IDataStorage objDS = CDataStorageFactory.getDataStorage();

        HashMap<String, String> objHM = new HashMap<>();

        objDS.openConnection();

        String strQuery = "SELECT severity, count(severity) FROM `dengue`\n"
                + "group by severity";

        ResultSet objRs = objDS.executeQuery(strQuery);

        while (objRs.next()) {
            if (objRs.getString("severity").equalsIgnoreCase("Alert")) {
                objHM.put("Red", objRs.getString(2));
            } else {
                objHM.put("Yellow", objRs.getString(2));
            }
        }
        objDS.closeConnection();

        return objHM;

    }

}
