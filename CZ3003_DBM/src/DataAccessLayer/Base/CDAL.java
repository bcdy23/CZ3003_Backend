/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer.Base;
import DataAccessLayer.CDataStorageFactory;
/**
 *
 * @author SHOUBI
 */
public abstract class CDAL {
    private final IDataStorage objDataStorage;
    
    public CDAL() {
        objDataStorage = CDataStorageFactory.getDataStorage();
    }

    protected IDataStorage getStorage() {
        return objDataStorage;
    }
}
