/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

/**
 *
 * @author mazen
 */
public class DoorSensorReading {
  private final int force;
  private final boolean active;

    public DoorSensorReading(int force, boolean active) {
        this.force = force;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
    

    public int getForce() {
        return force;
    }
   
    
}
