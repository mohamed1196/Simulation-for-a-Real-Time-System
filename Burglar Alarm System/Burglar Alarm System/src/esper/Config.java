/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esper;

import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;
import events.DoorSensorReading;
import events.PowerEvent;
import events.MovementSensorReading;
import events.PanicEvent;
import events.WindowSensorReading;
import events.powerLevelReader;


public class Config {

    private static EPServiceProvider engine = EPServiceProviderManager.getDefaultProvider();

    public static void registerEvents() {
        engine.getEPAdministrator().getConfiguration().addEventType(PowerEvent.class);
        engine.getEPAdministrator().getConfiguration().addEventType(MovementSensorReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(DoorSensorReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(WindowSensorReading.class);
        engine.getEPAdministrator().getConfiguration().addEventType(powerLevelReader.class);
        engine.getEPAdministrator().getConfiguration().addEventType(PanicEvent.class);

        System.out.println("Events Successfully Registered.");
    }

    public static EPStatement createStatement(String s) {
        EPStatement result = engine.getEPAdministrator().createEPL(s);
        System.out.println("EPL Statement Successfully Created.");
        return result;
    }
    
    public static void sendEvent(Object o)
    {
        engine.getEPRuntime().sendEvent(o);
    }

}
