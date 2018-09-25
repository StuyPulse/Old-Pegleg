package org.usfirst.frc.team694.robot.subsystems;

import org.usfirst.frc.team694.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	private WPI_TalonSRX leftTopMotor;
    private WPI_TalonSRX leftBottomMotor;
    private WPI_TalonSRX rightTopMotor;
    private WPI_TalonSRX rightBottomMotor;
    
    private DifferentialDrive differentialDrive;
    
    public Drivetrain() {
    		leftTopMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_TOP_MOTOR);
    		leftBottomMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_BOTTOM_MOTOR);
    		rightTopMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_TOP_MOTOR);
    		rightBottomMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_BOTTOM_MOTOR);
    		
    		leftBottomMotor.follow(leftTopMotor);
    		rightBottomMotor.follow(rightTopMotor);
    		
    		differentialDrive = new DifferentialDrive(leftTopMotor, rightTopMotor);
    }
    
    public void initDefaultCommand() {

    }
    
    public double getLeftSpeed() {
    		return leftTopMotor.getSelectedSensorVelocity(0);
    }
    
    public double getRightSpeed() {
    		return rightTopMotor.getSelectedSensorVelocity(0);
    }
    
    public double getSpeed() {
    		return Math.max(Math.abs(getLeftSpeed()), Math.abs(getRightSpeed()));
    }
    
    public void arcadeDrive(double speed, double turn) {
    		differentialDrive.arcadeDrive(speed, turn, true);
    }
    
    public void setRamp(double rampSeconds) {
    		leftTopMotor.configOpenloopRamp(rampSeconds, 0);
    		leftBottomMotor.configOpenloopRamp(rampSeconds, 0);
    		rightTopMotor.configOpenloopRamp(rampSeconds, 0);
    		rightBottomMotor.configOpenloopRamp(rampSeconds, 0);
    }
}

