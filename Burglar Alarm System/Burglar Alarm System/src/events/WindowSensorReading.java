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
public class WindowSensorReading {
    private final int pressure;
    private final boolean active;

    public WindowSensorReading(int pressure, boolean active) {
        this.pressure = pressure;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    

    public int getPressure() {
        return pressure;
    }
    
    
}
