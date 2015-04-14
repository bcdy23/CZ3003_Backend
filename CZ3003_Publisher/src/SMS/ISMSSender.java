/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMS;

import Enitity.CSMS;

/**
 *
 * @author Bryden
 */
public interface ISMSSender {

    public void sendSMS(CSMS pObjSMS) throws Exception;

}
