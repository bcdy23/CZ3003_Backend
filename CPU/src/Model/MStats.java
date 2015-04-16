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

/**
 *
 * @author Bryden
 */
public class MStats {

    public String getStats() throws SQLException {

        IDataStorage objDS = CDataStorageFactory.getDataStorage();

        StringBuilder objSB = new StringBuilder();

        objDS.openConnection();

        String strQuery = "SELECT incidentCategoryTitle, percentage \n"
                + "FROM `incidentcategorystat` s\n"
                + "inner join `incidentcategory` c\n"
                + "on s.incidentCategoryId = c.incidentCategoryId";

        ResultSet objRs = objDS.executeQuery(strQuery);

        while (objRs.next()) {
            objSB.append("{\"");

            objSB.append(objRs.getString(1));

            objSB.append("\" : ");

            objSB.append(objRs.getString(2));

            objSB.append("},");

        }

        objDS.closeConnection();

        objSB.deleteCharAt(objSB.lastIndexOf(","));

        return objSB.toString();
    }

}
