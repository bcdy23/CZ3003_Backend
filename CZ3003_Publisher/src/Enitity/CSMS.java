/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enitity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Bryden
 */
public class CSMS {
    
    private final String strFrom;
    private final List<String> strTo;
    
    private final String strMsg;
    
    public CSMS(String pStrFrom, String pStrTo, String pStrMsg) {
        strFrom = pStrFrom;
        
        strMsg = pStrMsg;
        
        strTo = new ArrayList<>();
        
        this.strTo.addAll(Arrays.asList(pStrTo.split(";")));
    }

    /**
     * @return the strFrom
     */
    public String getFrom() {
        return strFrom;
    }

    /**
     * @return the strTo
     */
    public List<String> getTo() {
        return strTo;
    }

    /**
     * @return the strMsg
     */
    public String getMsg() {
        return strMsg;
    }
    
    @Override
    public String toString() {
        StringBuilder objSB = new StringBuilder();
        
        objSB.append("From : ");
        objSB.append(this.getFrom());
        objSB.append("\n");
        
        objSB.append("Msg : ");
        objSB.append(this.getMsg());
        objSB.append("\n");
        
        objSB.append("To : ");
        for (String strTo : this.getTo()) {
            
            objSB.append(strTo);
            objSB.append(" ; ");
            
        }
        objSB.append("\n");
        
        return objSB.toString();
        
    }
    
}
