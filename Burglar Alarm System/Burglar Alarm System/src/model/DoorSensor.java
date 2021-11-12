/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.Config;
import events.DoorSensorReading;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DoorSensor extends Sensor{
    private int random(int min, int max) {
        
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    private boolean active;
    private int force;
    private int i;
    private int zoneID;
    public boolean DetectFailure(){
             
        if(i > 200){
             active=false;
             i=0;
         }else{
            i+=random(2,80);
        }
         
        return active;
    }

    public DoorSensor(BurglerAlarmSystem BAS) {
        super(BAS);
        this.force = 4;
        this.active=true;
        this.zoneID=1;
    }

    public int getZoneID() {
        return zoneID;
    }

    
    public void DetectDoorOpening() {
        if (force > 35) {
             force -= random(2, 15);
        } else {
            force += random(2, 20);
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
            
            Config.sendEvent(new DoorSensorReading(force,active));
        }
    }
    
    
}
