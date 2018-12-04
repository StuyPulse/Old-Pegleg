	/*----------------------------------------------------------------------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
	/* Open Source Software - may be modified and shared by FRC teams. The code   */
	/* must be accompanied by the FIRST BSD license file in the root directory of */
	/* the project.                                                               */
	/*----------------------------------------------------------------------------*/
	
	package org.usfirst.frc.team694.robot;
	
import org.usfirst.frc.team694.robot.commands.auton.routines.DifferentSideSwitchAutonCommand;
import org.usfirst.frc.team694.robot.commands.auton.routines.DriveForwardForeverAutonCommand;
import org.usfirst.frc.team694.robot.commands.auton.routines.SameSideSwitchAutonCommand;
import org.usfirst.frc.team694.robot.subsystems.Arm;
import org.usfirst.frc.team694.robot.subsystems.Drivetrain;
import org.usfirst.frc.team694.util.InfraredLightBeamDetectionUnit;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
	
	public class Robot extends TimedRobot {
		
	    private static Robot myInstance;
	
		public static Drivetrain drivetrain;
		public static Arm arm;
		
		public static InfraredLightBeamDetectionUnit irSensor;
	
		public static OI oi;
		public static SendableChooser<Command> autonChooser;
		
		private String gameData;
	    private static boolean isRobotOnRight;
	    private static boolean isAllianceSwitchRight;
	    private static boolean isScaleRight;
	    private static boolean isInTeleop;
	    
		@Override
		public void robotInit() {
			drivetrain = new Drivetrain();
			arm = new Arm();
			irSensor = new InfraredLightBeamDetectionUnit();
			
			autonChooser = new SendableChooser<>();
			
			initSmartDashboard();
		}
		
		public void robotPeriodic(){
			updateSmartDashboard();
		}
		public enum RobotStartPosition {
			RIGHT_SIDE_OF_DRIVER, LEFT_SIDE_OF_DRIVER
		}
		
		public void initSmartDashboard(){
			autonChooser.addDefault("infinite drive forward", new DriveForwardForeverAutonCommand());
			autonChooser.addObject("same side switch", new SameSideSwitchAutonCommand());
			autonChooser.addObject("different side switch", new DifferentSideSwitchAutonCommand(true));
			
			SmartDashboard.putData(autonChooser);
		}
		
		public void updateSmartDashboard(){
			SmartDashboard.putNumber("The Value We Have Gathered Using the Technology of The Infrared light Beam Echolocator Device that is located on the Robot that is Made By Team 694 from Stuyvesant High School in New York City", irSensor.getRawValue());
		}

	
		@Override
		public void disabledInit() {
			Scheduler.getInstance().removeAll();
		}
	
		@Override
		public void disabledPeriodic() {
			Scheduler.getInstance().run();
		}
	
		@Override
		public void autonomousInit() {
			autonChooser.getSelected().start();
		}
	
		@Override
		public void autonomousPeriodic() {
			Scheduler.getInstance().run();
		}
	
		@Override
		public void teleopInit() {
			isInTeleop = true;
			autonChooser.getSelected().cancel();
		}
	
		@Override
		public void teleopPeriodic() {
			Scheduler.getInstance().run();
		}
	
		@Override
		public void testPeriodic() {
		}
		
		public static boolean isRobotStartingOnRight() {
			return isRobotOnRight;
		}
	
		public static boolean isSwitchOnRight() {
		    return isAllianceSwitchRight;
		}
	
		public static boolean isScaleOnRight() {
			return isScaleRight;
		}
	
		public static boolean isRobotOnSameSideScale() {
			return !(isRobotOnRight ^ isScaleRight);
		}
	
		public static boolean isSwitchOnSameSideScale() {
		    return !(isAllianceSwitchRight ^ isScaleRight);
		}
	
		public static boolean isRobotSwitchScaleOnSameSide() {
		    return isRobotOnSameSideScale() && isSwitchOnSameSideScale();
		}
	
		public static boolean isRobotOnSameSideSwitch() {
		    return !(isRobotOnRight ^ isAllianceSwitchRight);
		}
	
		public static Robot getInstance() {
			return myInstance;
		}
	}
