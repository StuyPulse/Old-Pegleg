	/*----------------------------------------------------------------------------*/
	/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
	/* Open Source Software - may be modified and shared by FRC teams. The code   */
	/* must be accompanied by the FIRST BSD license file in the root directory of */
	/* the project.                                                               */
	/*----------------------------------------------------------------------------*/
	
	package org.usfirst.frc.team694.robot;
	
import org.usfirst.frc.team694.robot.commands.auton.choosers.SingleSwitchAutonChooserCommand;
import org.usfirst.frc.team694.robot.commands.auton.routines.DriveForwardForeverAutonCommand;
import org.usfirst.frc.team694.robot.subsystems.Arm;
import org.usfirst.frc.team694.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
	
	public class Robot extends TimedRobot {
		
	    private static Robot myInstance;
	
		public static Drivetrain drivetrain;
		public static Arm arm;
	
		public static OI oi;
		
		private String gameData;
	    private static boolean isRobotOnRight;
	    private static boolean isAllianceSwitchRight;
	    private static boolean isScaleRight;
	    private static boolean isInTeleop;
	
	    private static SendableChooser<Command> autonChooser = new SendableChooser<>();
	    private static SendableChooser<RobotStartPosition> sideChooser = new SendableChooser<>();
	
	    private Command autonCommand; 
	    
		@Override
		public void robotInit() {
			oi = new OI();
			drivetrain = new Drivetrain();
			arm = new Arm();
			
			initSmartDashboard();
		}
		
		public enum RobotStartPosition {
			RIGHT_SIDE_OF_DRIVER, LEFT_SIDE_OF_DRIVER
		}
	
		@Override
		public void disabledInit() {
			Scheduler.getInstance().removeAll();
		}
	
		@Override
		public void disabledPeriodic() {
			Scheduler.getInstance().run();
		}
		
		private void initSmartDashboard() {
			autonChooser.addDefault("Do Nothing", new CommandGroup());
			autonChooser.addObject("Mobility", new DriveForwardForeverAutonCommand());
			autonChooser.addObject("Single Switch", new SingleSwitchAutonChooserCommand());
			
			sideChooser.addDefault("Right", RobotStartPosition.RIGHT_SIDE_OF_DRIVER);
	        sideChooser.addObject("Left", RobotStartPosition.LEFT_SIDE_OF_DRIVER);
	        SmartDashboard.putData("Where is the bot starting?", sideChooser);
	        
	        SmartDashboard.putNumber("DrivePID P", 0.016);
	        SmartDashboard.putNumber("DrivePID I", 0);
	        SmartDashboard.putNumber("DrivePID D", 0.08);
		}
	
		@Override
		public void autonomousInit() {
			Scheduler.getInstance().removeAll();
	        isInTeleop = false;
			gameData = null;
	
	        double timestamp = Timer.getFPGATimestamp();
	        while ((Timer.getFPGATimestamp() - timestamp) < 5 && (gameData == null || gameData.isEmpty())) {
	            gameData = DriverStation.getInstance().getGameSpecificMessage();
	        }
	        if (gameData == null || gameData.isEmpty()) {//If there is no field data run mobility
	            //autonCommand = new MobilityAutonCommand();
	            System.err.print("******* Field Data Problem!!!");
	            System.err.println("Please yell at the field management crew to fix this");
	        } else {
	            isRobotOnRight = (sideChooser.getSelected() == RobotStartPosition.RIGHT_SIDE_OF_DRIVER);
	            System.out.println(
	                    "[Robot] SIDE CHOOSER: " + sideChooser.getSelected() + ", equals right? " + isRobotOnRight);
	            isAllianceSwitchRight = gameData.charAt(0) == 'R';
	            isScaleRight = gameData.charAt(1) == 'R';
	            autonCommand = autonChooser.getSelected();
	        }
	
	        if (autonCommand != null) {
	            System.out.println("[Robot] SELECTED AUTON: " + autonCommand.getName());
	            autonCommand.start();
	        }
		}
	
		@Override
		public void autonomousPeriodic() {
			Scheduler.getInstance().run();
		}
	
		@Override
		public void teleopInit() {
			isInTeleop = true;
			if (autonCommand != null) {
				autonCommand.cancel();
			}
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
