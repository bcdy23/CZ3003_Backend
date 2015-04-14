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
public class MHaze {

    public HashMap<String, String> getNationalPSIInfo() throws SQLException {
        IDataStorage objDS = CDataStorageFactory.getDataStorage();

        HashMap<String, String> objHM = new HashMap<>();

        objDS.openConnection();

        String strQuery = "SELECT psiValue, airQualityDescriptor FROM `haze`\n"
                + "WHERE region='national'";

        ResultSet objRs = objDS.executeQuery(strQuery);

        objRs.next();

        objHM.put("PSI", objRs.getString(1));
        objHM.put("Desc", objRs.getString(2));

        objDS.closeConnection();

        return objHM;

    }

}
