/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocialMedia;

/**
 *
 * @author Bryden
 */
public class CSocialMediaFactory {

    private static final ISocial objTwitter = new CTwitter();
    private static final ISocial objFacebook = new CFacebook();

    private CSocialMediaFactory() {
    }

    public static ISocial getTwitter() {
        return objTwitter;
    }

    public static ISocial getFacebook() {
        return objFacebook;
    }

}
