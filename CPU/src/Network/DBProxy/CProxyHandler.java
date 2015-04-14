/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network.DBProxy;

import DBProxy.Core.Engine;
import DBProxy.Plugins.CPluginManager;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Bryden
 */
public class CProxyHandler implements Observer {

    @Override
    public void update(Observable o, Object arg) {

        Socket objSocket = (Socket) arg;

        try {
            Engine objEngine = new Engine(objSocket.getPort(), objSocket, CPluginManager.getPlugins());
            objEngine.run();
        } catch (IOException ex) {

        }

    }

}
