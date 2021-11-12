/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Sensor extends Thread {

    private final BurglerAlarmSystem BAS;

    public Sensor(BurglerAlarmSystem BAS) {
        this.BAS = BAS;
    }

    @Override
    public void run() {
        while (true) {
            if (BAS.isSystemOn()) {
                BAS.getMovementSensor().DetectMovement();
                BAS.getDoor().DetectDoorOpening();
                BAS.getWindow().DetectWindowOpening();
            } 
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
