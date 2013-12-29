/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.muni.fi.pa165.carmanagement.soap.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 *
 * @author zvonicek
 */
public abstract class GeneralController {
    
    public GeneralController()
    {
        Authenticator myAuth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("rest", "rest".toCharArray());
            }
        };
        Authenticator.setDefault(myAuth);   
    }    
}
