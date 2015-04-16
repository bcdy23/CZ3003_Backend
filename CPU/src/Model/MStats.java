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

        String strQuery = "SELECT incidentCategoryTitle, percentage , 'Stats'\n"
                + "FROM `incidentcategorystat` s\n"
                + "inner join `incidentcategory` c\n"
                + "on s.incidentCategoryId = c.incidentCategoryId\n"
                + "union all\n"
                + "SELECT region,psiValue ,'Haze' FROM `haze`\n"
                + "union all\n"
                + "SELECT severity,count(*),'Dengue' FROM `dengue`\n"
                + "group by severity;";

        ResultSet objRs = objDS.executeQuery(strQuery);

        while (objRs.next()) {
            objSB.append("{\"");

            objSB.append(objRs.getString(1));

            objSB.append("\" : ");

            objSB.append(objRs.getString(2));

            objSB.append(",");

            objSB.append("\"Type\" : \"");

            objSB.append(objRs.getString(3));

            objSB.append("\"");

            objSB.append("},");

        }

        objDS.closeConnection();

        objSB.deleteCharAt(objSB.lastIndexOf(","));

        return objSB.toString();
    }

}
