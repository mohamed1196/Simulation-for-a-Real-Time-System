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
public class PanicEvent {
    private final boolean panic;

    public PanicEvent(boolean panic) {
        this.panic = panic;
    }

    public boolean isPanic() {
        return panic;
    }
    
    
}
