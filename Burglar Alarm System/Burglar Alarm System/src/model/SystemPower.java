/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.Config;
import events.MovementSensorReading;
import events.powerLevelReader;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mazen
 */
public class SystemPower extends Thread{
    
    private int random(int min, int max) {
       
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        
        Random r = new Random();
       
        return r.nextInt((max - min) + 1) + min;
    }
        private int powerlevel;

    public SystemPower() {
        this.powerlevel = 100;
    }

    
    public void DetectPowerLoss() {
        if (powerlevel < 30) {
            powerlevel += random(2, 30);
        } else {
            powerlevel -= random(2, 10);
        }
    }

    public int getPowerlevel() {
        return powerlevel;
    }
    
    
    @Override
    public void run() {
        while (true) {
            
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MovementSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Config.sendEvent(new powerLevelReader(powerlevel));
        }
    }
}
