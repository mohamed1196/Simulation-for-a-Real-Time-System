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
public class LightController {
     public void switch_lights_around_active_sensor(final int zoneID) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++)
                {
                    System.out.println("the lights of zone: "+zoneID+" are actived");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Siren.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
      public void switch_off_activelights(final int zoneID) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++)
                {
                    System.out.println("the lights of zone: "+zoneID+" are deactived");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Siren.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    
}
