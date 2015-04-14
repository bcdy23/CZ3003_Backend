/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBProxy.Plugins;

import DBProxy.Plugins.proxy.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryden
 */
public class CPluginManager {

    private CPluginManager() {
    }

    static {

    }

    public static List<Base> getPlugins() {

        List<Base> lstPlugin = new ArrayList<>();
        
        lstPlugin.add(new Proxy());
        
        return lstPlugin;
    }

}
