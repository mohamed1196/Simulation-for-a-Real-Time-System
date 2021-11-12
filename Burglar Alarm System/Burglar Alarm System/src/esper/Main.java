

package esper;

import model.BurglerAlarmSystem;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Disable logging
        Logger.getRootLogger().setLevel(Level.OFF);

        // Register events
        Config.registerEvents();

        // Create BurglerAlarmSystem
        final BurglerAlarmSystem BAS = new BurglerAlarmSystem();

        Config.createStatement("select movement from MovementSensorReading")
                .setSubscriber(new Object() {
                    public void update(int Movement) {
                        try {
                            BAS.MovementSensorSignal(Movement);
                        } catch (InterruptedException ex) {
                            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                });
        Config.createStatement("select force from DoorSensorReading")
                .setSubscriber(new Object() {
                    public void update(int force) {
                        try {
                            BAS.DoorSensorSignal(force);
                        } catch (InterruptedException ex) {
                            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                });
        Config.createStatement("select pressure from WindowSensorReading")
                .setSubscriber(new Object() {
                    public void update(int pressure) {
                        try {
                            BAS.WindowSensorSignal(pressure);
                        } catch (InterruptedException ex) {
                            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                });
        Config.createStatement("select active from MovementSensorReading")
                .setSubscriber(new Object() {
                    public void update(boolean active) {
                        try {
                            BAS.MovementSensorfailure(active);
                        } catch (InterruptedException ex) {
                            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                });
        Config.createStatement("select active from DoorSensorReading")
                .setSubscriber(new Object() {
                    public void update(boolean active) {
                        try {
                            BAS.DoorSensorfailure(active);
                        } catch (InterruptedException ex) {
                            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                });
        Config.createStatement("select active from WindowSensorReading")
                .setSubscriber(new Object() {
                    public void update(boolean active) {
                        try {
                            BAS.WindowSensorfailure(active);
                        } catch (InterruptedException ex) {
                            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                });
        Config.createStatement("select powerlevel from powerLevelReader")
                .setSubscriber(new Object() {
                    public void update(int power) {
                        try {
                            BAS.PowerLevelLoss(power);
                        } catch (InterruptedException ex) {
                            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                    }
                });

        Config.createStatement("select state from PowerEvent")
                .setSubscriber(new Object() {
                    public void update(boolean state) {
                        BAS.setState(state);
                    }
                });
        Config.createStatement("select panic from PanicEvent")
                .setSubscriber(new Object() {
                    public void update(boolean panic) {
                        BAS.setPanic(panic);
                    }
                });
        
    }

}
