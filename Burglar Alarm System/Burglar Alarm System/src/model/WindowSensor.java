/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.Config;
import events.WindowSensorReading;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class WindowSensor extends Sensor {
    private int random(int min, int max) {
        
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    private int pressure;
     private boolean active;
     private int i;
     private int zoneID;
     
      public boolean DetectFailure(){
             
        if(i > 400){
             active=false;
             i=0;
         }else{
            i+=random(2,90);
        }
         
        return active;
    }

    public WindowSensor( BurglerAlarmSystem BAS) {
        super(BAS);
        this.pressure = 3;
        this.active=true;
        this.zoneID=3;
    }

    public int getZoneID() {
        return zoneID;
    }

   
    public void DetectWindowOpening() {
        if (pressure > 30) {
             pressure -= random(2, 15);
        } else {
            pressure += random(2, 15);
        }
    }

    @Override
    public void run() {
         while (true) {
            
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MovementSensor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Config.sendEvent(new WindowSensorReading(pressure,active));
        }
    }
    
    
}
