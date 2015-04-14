/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBProxy.Core;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author bcho002
 */
public class CMySQLSocket extends Socket {

    public CMySQLSocket(String pStrHost, int pStrPort) throws SocketException, IOException {
        super(pStrHost, pStrPort);
        this.setPerformancePreferences(0, 2, 1);
        this.setTcpNoDelay(true);
        this.setTrafficClass(0x10);
        this.setKeepAlive(true);
    }

}
