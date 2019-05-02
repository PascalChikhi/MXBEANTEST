/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mxbeantest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 *
 * @author PCH
 */
public class JMXMainlauncher {
 
    private static final Logger LOG = LoggerFactory.getLogger(JMXMainlauncher.class);

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        LOG.debug("This is basic JMX tutorial");
        ObjectName objectName = null;
        try {
            objectName = new ObjectName("com.baeldung.tutorial:type=basic,name=game");
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        }
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        SystemStatus gameObj = new SystemStatus("game");
        try {
            server.registerMBean(gameObj, objectName);
        } catch (InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException e) {
            e.printStackTrace();
        }
        LOG.debug("Registration for Game mbean with the platform server is successfull");
        LOG.debug("Please open jconsole to access Game mbean");
        while (true) {
            // to ensure application does not terminate
        }
}    
    
}
