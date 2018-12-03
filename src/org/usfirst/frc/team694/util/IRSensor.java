package org.usfirst.frc.team694.util;

import edu.wpi.first.wpilibj.AnalogInput;

public class IRSensor {
	AnalogInput IRSensor;
	public IRSensor(){
		IRSensor = new AnalogInput(0);
	}
	public double getValueIR(){
		return IRSensor.getValue();
	}
}

