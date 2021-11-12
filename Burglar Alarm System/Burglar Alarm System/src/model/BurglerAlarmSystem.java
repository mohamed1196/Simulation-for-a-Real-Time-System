/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import esper.Config;
import events.PowerEvent;
import java.util.Random;
import view.AlarmView;


public class BurglerAlarmSystem {

    // The BurglerAlarmSystem GUI
    private AlarmView gui;

    // This acts as our ON/OFF switch
    private boolean state = false;

    // The components of our BurglerAlarmSystem
    private MovementSensor movementSensor;
    private Siren siern;
    private Sensor sensor;
    private DoorSensor doorSensor;
    private WindowSensor windowSensor;
    private Police police;
    private ServiceTechnician technician;
    private SensorMonitor monitor;
    private SystemPower Systempower;
    private PowerCircuitMonitor Pmonitor;
    private VoiceSynthesiser VS;
    private LightController LC;
    private PanicBtn PB;
    public BurglerAlarmSystem() {
        
        gui = new AlarmView();
        gui.setLocationRelativeTo(null);
        gui.setVisible(true);
        
        siern =  new Siren();
        police=new Police();
        technician = new ServiceTechnician();
        Systempower = new SystemPower();
        PB = new PanicBtn();
        VS=new VoiceSynthesiser();
        LC = new LightController();
        Pmonitor=new PowerCircuitMonitor(this);
        monitor=new SensorMonitor(this);
        movementSensor = new MovementSensor(this);
        sensor = new Sensor(this);
        doorSensor = new DoorSensor(this);
        windowSensor = new WindowSensor(this);
        movementSensor.start();
        sensor.start();
        doorSensor.start();
        windowSensor.start();
        monitor.start();
        Systempower.start();
        Pmonitor.start();
    }
    
    public boolean isSystemOn() {
        return state;
    }
    
    public void MovementSensorSignal(int movement) throws InterruptedException {
        System.out.println("The Movement signal is now " + movement);
        gui.getCurrentMovementRate().setText(movement + "");
        
        if (movement >= 50) {
            siern.beep();
            police.CallPolice();
            VS.report_intruder_location(movementSensor.getZoneID());
            LC.switch_lights_around_active_sensor(movementSensor.getZoneID());
            Config.sendEvent(new PowerEvent(false));
        }
    }
    public void DoorSensorSignal(int force) throws InterruptedException {
        System.out.println("The Door force is now " + force);
        gui.getCurrentDoorForce().setText(force + "");
        
        if (force >= 50) {
            siern.beep();
            police.CallPolice();
            VS.report_intruder_location(doorSensor.getZoneID());
            LC.switch_lights_around_active_sensor(doorSensor.getZoneID());
            Config.sendEvent(new PowerEvent(false));
        }
    }
    public void WindowSensorSignal(int pressure) throws InterruptedException {
        System.out.println("The Window pressure is now " + pressure);
        gui.getCurrentWindowPressure().setText(pressure + "");
        
        if (pressure >= 55) {
            siern.beep();
            police.CallPolice();
            VS.report_intruder_location(windowSensor.getZoneID());
            LC.switch_lights_around_active_sensor(windowSensor.getZoneID());
            Config.sendEvent(new PowerEvent(false));
        }
    }
    public void MovementSensorfailure(boolean status) throws InterruptedException {
        System.out.println("The movment sensor status is now " + status);
        //gui.getCurrentTempTxt().setText(status + "");
        
        if (status == false) {
            technician.CallTechnician();
            movementSensor.setActive(true);
            System.out.println("for movement sensor");

        }
    }
    public void DoorSensorfailure(boolean status) throws InterruptedException {
        System.out.println("The Door sensor status is now " + status);
        //gui.getCurrentTempTxt().setText(status + "");
        
        if (status == false) {
            technician.CallTechnician();
            movementSensor.setActive(true);
            System.out.println("for Door sensor");

        }
    }
    public void WindowSensorfailure(boolean status) throws InterruptedException {
        System.out.println("The Window sensor status is now " + status);
        //gui.getCurrentTempTxt().setText(status + "");
        
        if (status == false) {
            technician.CallTechnician();
            movementSensor.setActive(true);
            System.out.println("for Window sensor");

        }
    }
    public void PowerLevelLoss(int level) throws InterruptedException {
        System.out.println("The System Power Level is now " + level);
        //gui.getCurrentTempTxt().setText(status + "");
        
        if (level < 10) {
            technician.CallTechnician();
            System.out.println("backup is Active!!!!");

        }
    }

    public SystemPower getSystempower() {
        return Systempower;
    }
    
    
    
    
    public MovementSensor getMovementSensor() {
        return movementSensor;
    }
    
    public Siren getBeeper() {
        return siern;
    }
    
    public Sensor getSensor() {
        return sensor;
    }

    public DoorSensor getDoor() {
        return doorSensor;
    }

    public WindowSensor getWindow() {
        return windowSensor;
    }
    
    
    public AlarmView getGUI() {
        return gui;
    }
    
    public void setState(boolean state) {
        this.state = state;
        gui.getOnBtn().setEnabled(!state);
        gui.getOffBtn1().setEnabled(state);
        gui.getPanic().setEnabled(true);
    }
    public void setPanic(boolean panic) {
        if (panic == true) {
            PB.Panic();
            police.CallPolice();
            siern.beep();
        }
    }
    
}
