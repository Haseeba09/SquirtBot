import lejos.hardware.*;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.Color;
import lejos.robotics.LightDetector;
import lejos.robotics.RangeFinder;
import lejos.robotics.RangeFinderAdapter;
import lejos.robotics.RegulatedMotor;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("Hello World");
//	    Button.waitForAnyPress();
		
		EV3ColorSensor light = new EV3ColorSensor(SensorPort.S2);
		EV3UltrasonicSensor ultraSonic = new EV3UltrasonicSensor(SensorPort.S1);
		RangeFinderAdapter sonar = new RangeFinderAdapter(ultraSonic);
		RegulatedMotor m = new EV3LargeRegulatedMotor(MotorPort.A);
		
		light.setFloodlight(Color.RED);
		
		System.out.println("Hello World");
		while(true){
//			if(light.getFloodlight() > 1){
//				System.out.println("Out of soap");
//			}
			
			if(sonar.getRange() <= 0.01){
				m.setSpeed(250);
				m.rotate(960);
				m.rotate(-960);
				
			}
			
			if(light.getColorID() != Color.RED){
				
			}
			
			if(Button.ESCAPE.isDown()){
				break;
			}
			
		}
		
	}

}
