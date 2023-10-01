/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.webapp.ejb;

import javax.ejb.Remote;
import javax.ejb.Timer;


@Remote
public interface MyTimerSessionBeanRemote {
    public void myTimer(Timer timer);
    
    public void createTimer(long duration);
}
