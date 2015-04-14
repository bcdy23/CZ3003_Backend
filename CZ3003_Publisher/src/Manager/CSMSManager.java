/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Enitity.CSMS;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Bryden
 */
public class CSMSManager {

    public static List<CSMS> loadFromJson(JSONArray pAryJson) {

        List<CSMS> lstSMS = new ArrayList<>();

        for (Object objJson : pAryJson) {

            JSONObject objInnerObj = (JSONObject) objJson;

            CSMS objSMS = new CSMS(objInnerObj.get("from").toString(), 
                    objInnerObj.get("to").toString(), objInnerObj.get("msg").toString());
            
            lstSMS.add(objSMS);

        }

        return lstSMS;

    }

}
