/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import DataAccessLayer.Base.IDataStorage;
import DataAccessLayer.CDataStorageFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Bryden
 */
public class MHaze {

    public HashMap<String, String> getNationalPSIInfo() throws SQLException {
        IDataStorage objDS = CDataStorageFactory.getDataStorage();

        HashMap<String, String> objHM = new HashMap<>();

        objDS.openConnection();

        String strQuery = "SELECT psiValue, airQualityDescriptor FROM `haze`\n"
                + "WHERE region='national'";

        ResultSet objRs = objDS.executeQuery(strQuery);

        objRs.next();

        objHM.put("PSI", objRs.getString(1));
        objHM.put("Desc", objRs.getString(2));

        objDS.closeConnection();

        return objHM;

    }

    public void addHazeInfo(String pStrString) throws ParseException {
      IDataStorage objDS = CDataStorageFactory.getMasterStorage();

        StringBuilder objSB = new StringBuilder();
        objSB.append("INSERT INTO `dengue`(`polygon`, `region`, `noOfPeopleInfected`, `severity`)"
                + "VALUES ");

        JSONParser jsonParser = new JSONParser();

        JSONArray aryJSON = (JSONArray) jsonParser.parse(pStrString);

        for (Object objJson : aryJSON) {
            objSB.append("('");
            JSONObject objInnerObj = (JSONObject) objJson;

            objSB.append(objInnerObj.get("XYs").toString());
            objSB.append("','");

            objSB.append(objInnerObj.get("Location").toString());
            objSB.append("','");

            objSB.append(objInnerObj.get("Cases").toString());
            objSB.append("','");

            if (Integer.parseInt(objInnerObj.get("Cases").toString()) < 10) {
                objSB.append("warning'),");
            } else {
                objSB.append("alert'),");
            }
        }

        objSB.deleteCharAt(objSB.lastIndexOf(","));

        objSB.append(";");
        
        System.out.println(objSB);
        
        objDS.openConnection();

        objDS.executeScalar("truncate table haze");
        objDS.executeScalar(objSB.toString());

        objDS.closeConnection();

    }

}
