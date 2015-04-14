/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dengue;

import Entity.CDengueCluster;
import org.json.JSONObject;

/**
 *
 * @author Bryden
 */
public class CDengueFactory {
    
    public static CDengueCluster loadCluster(JSONObject pObjJson) {
        return new CDengueCluster(pObjJson.getInt("Number of cases"), pObjJson.getString("DESCRIPTION"), pObjJson.getString("XY"));
    }
    
}
