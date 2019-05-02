/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmxtest2;

import java.lang.management.ManagementFactory;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 *
 * @author PCH
 */
public class SystemConfigManagement {
    
    private static final int DEFAULT_NO_THREADS=100;
    private static final String DEFAULT_SCHEMA="default";

    public static void main(String[] args) throws MalformedObjectNameException, InterruptedException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        //Get the MBean server
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        //register the MBean
        SystemConfig mBean = new SystemConfig(DEFAULT_NO_THREADS, DEFAULT_SCHEMA);
        ObjectName name = new ObjectName("com.journaldev.jmx:type=SystemConfig");
        mbs.registerMBean(mBean, name);
        do{
            Thread.sleep(3000);
            int k = mBean.getThreadCount();
            k--;
            mBean.setThreadCount(k);
            System.out.println("Thread Count="+mBean.getThreadCount()+":::Schema Name="+mBean.getSchemaName());
        }while(mBean.getThreadCount() !=0);
        
    }
    
}
