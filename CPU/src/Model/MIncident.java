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
public class MIncident {

    public MIncident() {

    }

    public HashMap<String, String> loadIncidentInfo(int pIntId) throws SQLException {

        IDataStorage objDS = CDataStorageFactory.getDataStorage();

        HashMap<String, String> objHM = new HashMap<>();

        objDS.openConnection();

        String strQuery = "SELECT incidentCategoryTitle, address FROM `incident` i\n"
                + "natural join incidentcategory ic\n"
                + "WHERE incidentId = " + pIntId;

        ResultSet objRs = objDS.executeQuery(strQuery);

        objRs.next();

        objHM.put("Title", objRs.getString(1));
        objHM.put("Address", objRs.getString(2));

        objDS.closeConnection();

        return objHM;

    }

    public String loadIncidentCategory(String intId) throws SQLException {

        IDataStorage objDS = CDataStorageFactory.getDataStorage();

        String strOut = "";

        objDS.openConnection();

        String strQuery = "SELECT `incidentCategoryTitle` FROM `incidentcategory`\n"
                + "where `incidentCategoryID` = " + intId;

        ResultSet objRs = objDS.executeQuery(strQuery);

        if (objRs.next()) {
            strOut = objRs.getString(1);
        }

        objDS.closeConnection();

        return strOut;

    }

}
