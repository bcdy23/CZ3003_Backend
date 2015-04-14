/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import GPS.LatLonCoordinate;
import GPS.SVY21;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryden
 */
public class CDengueCluster {

    private int intCases;
    private final List<LatLonCoordinate> lstXYs = new ArrayList<>();
    private String strLocation;

    public CDengueCluster(int pIntCases, String pStrLocation, String pStrXYs) {

        this.setCases(pIntCases);
        this.setLocation(pStrLocation);

        for (String strXY : pStrXYs.split("\\|")) {

            double dblNorthing = Double.parseDouble(strXY.split(",")[0]);
            double dblEasting = Double.parseDouble(strXY.split(",")[1]);

            this.setXY(SVY21.computeLatLon(dblNorthing, dblEasting));
        }
    }

    public String toJSON() {
        StringBuilder objSB = new StringBuilder();

        objSB.append("{");
        
        objSB.append("\"Location\" : \"");
        objSB.append(this.getLocation());
        objSB.append("\",");

        objSB.append("\"Cases\" :");
        objSB.append(this.getCases());
        objSB.append(",");

        objSB.append("\"XYs\" :\"");

        this.getXY().stream().forEach((objCoord) -> {
            objSB.append(objCoord.getLongitude());
            objSB.append("|");
            objSB.append(objCoord.getLatitude());
            objSB.append(",");
        });

        
        objSB.deleteCharAt(objSB.lastIndexOf(","));
        objSB.append("\"}");
        

        return objSB.toString();
    }

    @Override
    public String toString() {

        StringBuilder objSB = new StringBuilder();

        objSB.append("Location : ");
        objSB.append(this.getLocation());
        objSB.append("\n");

        objSB.append("Cases :");
        objSB.append(this.getCases());
        objSB.append("\n");

        objSB.append("XYs :");

        this.getXY().stream().forEach((objCoord) -> {
            objSB.append(objCoord);
        });

        objSB.append("\n");

        return objSB.toString();

    }

    /**
     * @return the intCases
     */
    public int getCases() {
        return intCases;
    }

    /**
     * @param intCases the intCases to set
     */
    public final void setCases(int intCases) {
        this.intCases = intCases;
    }

    /**
     * @return the strXY
     */
    public List<LatLonCoordinate> getXY() {
        return lstXYs;
    }

    /**
     * @param strXY the strXY to set
     */
    public final void setXY(LatLonCoordinate strXY) {
        this.lstXYs.add(strXY);
    }

    /**
     * @return the strLocation
     */
    public String getLocation() {
        return strLocation;
    }

    /**
     * @param strLocation the strLocation to set
     */
    public final void setLocation(String strLocation) {
        this.strLocation = strLocation;
    }

}
