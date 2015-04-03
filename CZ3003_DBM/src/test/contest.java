/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DataAccessLayer.Base.IDataStorage;
import DataAccessLayer.CDataStorageFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author SHOUBI
 */
public class contest {
    
    public static void main(String []args) throws SQLException
            
    {
       
        String mySqlQuery = "DELETE FROM `agency` WHERE `agencyID` =4";
            IDataStorage objDS = CDataStorageFactory.getMasterStorage();
            
            objDS.openConnection();
            
            //for execute insert query
            int objRS = objDS.executeScalar(mySqlQuery);
            
            System.out.print(objRS);
            
            
            //for execute select query
            /*
            ResultSet objRS = objDS.executeQuery(mySqlQuery);

            while(objRS.next())
            {
                System.out.println(objRS.getString(2));
            }
            */

            objDS.closeConnection();
    
        
       
    }
    
}
