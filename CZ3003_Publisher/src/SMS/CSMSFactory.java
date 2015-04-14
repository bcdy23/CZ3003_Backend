/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMS;

/**
 *
 * @author Bryden
 */
public class CSMSFactory {

    private static final ISMSSender objSMS = new CSMSSender();

    private CSMSFactory() {
    }

    public static ISMSSender getSMSSender() {
        return objSMS;
    }
    
}
