/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CZ3003_Subscriber;

import Dengue.CDengueManager;
import Haze.CHazeManager;

/**
 *
 * @author Bryden
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        CDengueManager.schedulePolling();
        CHazeManager.schedulePolling();

    }

}
