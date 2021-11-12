/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.Config;
import events.MovementSensorReading;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MovementSensor extends Sensor {
    private int random(int min, int max) {
       
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        
        Random r = new Random();
       
        return r.nextInt((max - min) + 1) + min;
    }
    
    private boolean active;
    private int movement;
    private int i;
    private int zoneID;
    
    public MovementSensor(BurglerAlarmSystem BAS) {
        super(BAS);
        this.movement = 5;
        this.active=true;
        this.zoneID=2;
    }
    public boolean DetectFailure(){
             
        if(i > 300){
             active=false;
             i=0;
         }else{
            i+=random(2,80);
        }
         
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getZoneID() {
        return zoneID;
    }
    
   
    
    
    public void DetectMovement() {
        if (movement > 30) {
             movement -= random(2, 15);
        } else {
            movement += random(2, 30);
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
            
            Config.sendEvent(new MovementSensorReading(movement,active));
        }
    }
    
}
