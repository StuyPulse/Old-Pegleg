package org.usfirst.frc.team694.util;

import org.usfirst.frc.team694.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;

public class InfraredLightBeamDetectionUnit {
	private AnalogInput InfraredLightBeamDetectionUnit;
	public InfraredLightBeamDetectionUnit(){
		InfraredLightBeamDetectionUnit = new AnalogInput(RobotMap.INFRARED_LIGHT_BEAM_DETECTION_UNIT_PORT);
	}
	
	public int getRawValue(){
		return InfraredLightBeamDetectionUnit.getValue();
	}
}
