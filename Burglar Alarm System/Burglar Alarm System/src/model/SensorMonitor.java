/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mazen
 */
public class SensorMonitor extends Thread {
    
    private final BurglerAlarmSystem BAS;

    public SensorMonitor(BurglerAlarmSystem BAS) {
        this.BAS = BAS;
    }

    @Override
    public void run() {
        while (true) {
            if (BAS.isSystemOn()) {
                BAS.getMovementSensor().DetectFailure();
                BAS.getDoor().DetectFailure();
                BAS.getWindow().DetectFailure();
            } 
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SensorMonitor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
