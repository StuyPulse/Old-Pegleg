package org.usfirst.frc.team694.robot.subsystems;

import org.usfirst.frc.team694.robot.Robot;
import org.usfirst.frc.team694.robot.RobotMap;
import org.usfirst.frc.team694.robot.commands.DrivetrainDriveCommand;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private VictorSP leftTopMotor;
    private VictorSP leftBottomMotor;
    private VictorSP rightTopMotor;
    private VictorSP rightBottomMotor;
    
    private SpeedControllerGroup leftMotors;
    private SpeedControllerGroup rightMotors;
    
    private DifferentialDrive differentialDrive;
    
    
    public Drivetrain() {
    		leftTopMotor = new VictorSP(RobotMap.DRIVETRAIN_LEFT_TOP_MOTOR);
    		leftBottomMotor = new VictorSP(RobotMap.DRIVETRAIN_LEFT_BOTTOM_MOTOR);
    		rightTopMotor = new VictorSP(RobotMap.DRIVETRAIN_RIGHT_TOP_MOTOR);
    		rightBottomMotor = new VictorSP(RobotMap.DRIVETRAIN_RIGHT_BOTTOM_MOTOR);
    		
//    		leftBottomMotor.follow(leftTopMotor);
//    		rightBottomMotor.follow(rightTopMotor);
//    		
//    		leftBottomMotor.setNeutralMode(NeutralMode.Brake);
//    		rightBottomMotor.setNeutralMode(NeutralMode.Brake);
//    		leftTopMotor.setNeutralMode(NeutralMode.Brake);
//    		leftTopMotor.setNeutralMode(NeutralMode.Brake);

    		leftMotors = new SpeedControllerGroup(leftTopMotor, leftBottomMotor);
    		rightMotors = new SpeedControllerGroup(rightTopMotor, rightBottomMotor);
    		
    		differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
    }
    
    public void initDefaultCommand() {
    		Robot.drivetrain.setDefaultCommand(new DrivetrainDriveCommand());
    }
    
    public double getLeftSpeed() {
    		return leftTopMotor.get();
    }
    
    public double getRightSpeed() {
    		return rightTopMotor.get();
    }
    
    public double getSpeed() {
    		return Math.max(Math.abs(getLeftSpeed()), Math.abs(getRightSpeed()));
    }
    
    public void curvatureDrive(double speed, double turn, boolean quickTurn) {
    		differentialDrive.curvatureDrive(speed, turn, quickTurn);
    }
    
    public void arcadeDrive(double speed, double turn) {
    		differentialDrive.arcadeDrive(speed, turn, true);
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed) {
	    	differentialDrive.tankDrive(leftSpeed, rightSpeed);
    }
    
    
   
}

