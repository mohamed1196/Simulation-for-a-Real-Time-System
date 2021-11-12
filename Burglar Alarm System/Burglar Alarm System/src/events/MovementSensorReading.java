/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;


public class MovementSensorReading {
    
    private final int movement;
    private final boolean active;

    public MovementSensorReading(int movement, boolean active) {
        this.movement = movement;
        this.active = active;
    }
    
    
    
    public int getMovement() {
        return movement;
    }

    public boolean isActive() {
        return active;
    }
    
}
