/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mxbeantest;

/**
 *
 * @author PCH
 */
public interface SystemStatusMBean {
    
Integer getNumberOfSecondsRunning();
String getProgramName();
Long getNumberOfUnixSecondsRunning();
Boolean getSwitchStatus();    
    
}
