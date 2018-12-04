package org.usfirst.frc.team694.util;

import org.usfirst.frc.team694.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;

public class LineSensor {
	AnalogInput LineSensor;
	public LineSensor() {
		LineSensor = new AnalogInput(RobotMap.LINE_SENSOR_PORT);
	}
	public int getValue() {
		return LineSensor.getValue();
	}
}
