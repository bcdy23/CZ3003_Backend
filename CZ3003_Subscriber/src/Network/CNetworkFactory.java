/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.IOException;

/**
 *
 * @author Bryden
 */
public class CNetworkFactory {

    public static CUrlRequest createDengueClusterRequest() throws IOException {
        return new CUrlRequest("http://www.onemap.sg/API/services.svc/mashupData?token=qo/s2TnSUmfLz+32CvLC4RMVkzEFYjxqyti1KhByvEacEdMWBpCuSSQ+IFRT84QjGPBCuz/cBom8PfSm3GjEsGc8PkdEEOEr&themeName=DENGUE_CLUSTER&otptFlds=NAME&extents=-4423.6,15672.6,69773.4,52887.4");
    }

}
