/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import DataAccessLayer.Base.IDataStorage;
import Settings.CSettingManager;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author SHOUBI
 */
public class CMySQLDataStore implements IDataStorage {

    Connection objConn;
    DataSource ds;

    /**
     * Uses JDBC connection pooling to initialise data source
     */
    public CMySQLDataStore(String Sname, int Pnumber) {
        
        MysqlDataSource objDs = new MysqlDataSource();

        objDs.setServerName(Sname);
        objDs.setPortNumber(Pnumber);
                
        objDs.setUser(CSettingManager.getSetting("DB_User"));
        objDs.setPassword(CSettingManager.getSetting("DB_Pwd"));
        objDs.setDatabaseName(CSettingManager.getSetting("DB_Database"));

        ds = objDs;

    }

    @Override
    public void openConnection() {

        try {
            objConn = ds.getConnection();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public ResultSet executeQuery(String pStrQuery) {

        ResultSet objData = null;

        try {
            objData = objConn.createStatement().executeQuery(pStrQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return objData;
    }

    @Override
    public CallableStatement getStoredProc(String pStrProc) {

        CallableStatement objStmt = null;

        try {
            objStmt = objConn.prepareCall(pStrProc);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objStmt;

    }

    @Override
    public ResultSet executeStoredProc(CallableStatement pObjProc) {
        ResultSet objData = null;

        try {
            objData = pObjProc.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return objData;
    }

    @Override
    public void startTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void commitTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rollbackTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection() {
        try {
            objConn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int executeScalar(String pStrQuery) {

        int intReturn = -1;

        try {
            intReturn = objConn.createStatement().executeUpdate(pStrQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return intReturn;

    }
}
