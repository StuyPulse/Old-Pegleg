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
import org.usfirst.frc.team694.util.IRSensor;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
	
	public class Robot extends TimedRobot {
		
	    private static Robot myInstance;
	
		public static Drivetrain drivetrain;
		public static Arm arm;
		private static SendableChooser<Command> autonChooser;
		public static OI oi;
		public static IRSensor irSensor;
		
		private String gameData;
	    private static boolean isRobotOnRight;
	    private static boolean isAllianceSwitchRight;
	    private static boolean isScaleRight;
	    private static boolean isInTeleop;
	
	    private Command autonCommand;
	    double rightJoystickY;
		double leftJoystickY;
		@Override
		public void robotInit() {
			drivetrain = new Drivetrain();
			arm = new Arm();
			oi = new OI();
			autonChooser = new SendableChooser<>();
			irSensor = new IRSensor();
			
			initSmartDashboard();
		}
		public void robotPeriodic(){
			updateSmartDashboard();
		}
		private void initSmartDashboard(){
			autonChooser.addDefault("Drive Forward", new DriveForwardForeverAutonCommand());
			autonChooser.addObject("Same Side Switch", new SameSideSwitchAutonCommand());
			SmartDashboard.putData("Auton Chooser", autonChooser);
		}
		
		private void updateSmartDashboard(){
			SmartDashboard.putNumber("IR Sensor", irSensor.getValueIR());
		}
		
		public enum RobotStartPosition {
			RIGHT_SIDE_OF_DRIVER, LEFT_SIDE_OF_DRIVER
		}
	
		@Override
		public void disabledInit() {
			Scheduler.getInstance().removeAll();
		}
	
		@Override
		public void disabledPeriodic()
		{
			Scheduler.getInstance().run();
		}
	
		@Override
		public void autonomousInit() {
				        
		}
	
		@Override
		public void autonomousPeriodic() {
			Scheduler.getInstance().run();
		}
	
		@Override
		public void teleopInit() {
			isInTeleop = true;
			
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
