/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team694.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int DRIVETRAIN_LEFT_TOP_MOTOR = -1;
	public static final int DRIVETRAIN_LEFT_BOTTOM_MOTOR = -1;
	public static final int DRIVETRAIN_RIGHT_TOP_MOTOR = -1;
	public static final int DRIVETRAIN_RIGHT_BOTTOM_MOTOR = -1;
	
	public static final int ARM_MOTOR = -1;
	public static final int ARM_INTAKE_SOLENOID = -1;
	public static final int ARM_ELEVATION_SOLENOID = -1;
	
	public static final int GAMEPAD_OPERATOR_PORT = -1;
	public static final int GAMEPAD_DRIVER_PORT = -1;
}
