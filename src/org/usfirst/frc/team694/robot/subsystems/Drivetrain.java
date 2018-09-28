package org.usfirst.frc.team694.robot.subsystems;

import org.usfirst.frc.team694.robot.Robot;
import org.usfirst.frc.team694.robot.RobotMap;
import org.usfirst.frc.team694.robot.commands.DrivetrainDriveCommand;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private PWMVictorSPX leftTopMotor;
    private PWMVictorSPX leftBottomMotor;
    private PWMVictorSPX rightTopMotor;
    private PWMVictorSPX rightBottomMotor;
    
    private SpeedControllerGroup leftMotors;
    private SpeedControllerGroup rightMotors;
    
    private DifferentialDrive differentialDrive;
    
    
    public Drivetrain() {
    		leftTopMotor = new PWMVictorSPX(RobotMap.DRIVETRAIN_LEFT_TOP_MOTOR);
    		leftBottomMotor = new PWMVictorSPX(RobotMap.DRIVETRAIN_LEFT_BOTTOM_MOTOR);
    		rightTopMotor = new PWMVictorSPX(RobotMap.DRIVETRAIN_RIGHT_TOP_MOTOR);
    		rightBottomMotor = new PWMVictorSPX(RobotMap.DRIVETRAIN_RIGHT_BOTTOM_MOTOR);
    		
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
    
    public void arcadeDrive(double speed, double turn) {
    		differentialDrive.arcadeDrive(speed, turn, true);
    }
   
}

