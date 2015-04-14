/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Base;
import java.sql.CallableStatement;
import java.sql.ResultSet;
/**
 *
 * @author SHOUBI
 */
public interface IDataStorage {
     /**
     * Open Connection to Database
     */
    public void openConnection();
    
    /**
     * Method to execute any query to database
     * @param pStrQuery
     * @return 
     */
    public ResultSet executeQuery(String pStrQuery);
    
    public int executeScalar(String pStrQuery);
    
    /**
     * Method to return an stored procedure instance based on name
     * @param pStrProc
     * @return 
     */
    public CallableStatement getStoredProc(String pStrProc);
    
    /**
     * Execution of Stored procedure
     * @param pObjProc
     * @return 
     */
    public ResultSet executeStoredProc(CallableStatement pObjProc);
    
    public void startTransaction();
    public void commitTransaction();
    public void rollbackTransaction();
    
    /**
     * Close Connection
     */
    public void closeConnection();
}
