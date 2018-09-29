package org.usfirst.frc.team694.robot.subsystems;

import org.usfirst.frc.team694.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    private WPI_TalonSRX motor;
    
    private Solenoid intakeSolenoid;
    private Solenoid elevationSolenoid;
    
    public boolean isOpen;

    public Arm() {
    		motor = new WPI_TalonSRX(RobotMap.ARM_MOTOR);
    		intakeSolenoid = new Solenoid(RobotMap.ARM_INTAKE_SOLENOID);
    		elevationSolenoid = new Solenoid(RobotMap.ARM_ELEVATION_SOLENOID);
    }
    
    public void initDefaultCommand() {
    	
    }
    
    public double getSpeed() {
    		return motor.getSelectedSensorVelocity(0);
    }
    
    public void acquire() {
    	motor.set(1);
    }
    
    public void deacquire() {
    	motor.set(-1);
    }
    
    public void stop() {
    	motor.set(0);
    }
    
    public void setSpeed(double speed) {
    		motor.set(speed);
    }
    
    public void open() {
    		intakeSolenoid.set(true);
    }
    
    public void close() {
    		intakeSolenoid.set(false);
    }
    
    public void up() {
    		elevationSolenoid.set(false);
    }
    public void down() {
    		elevationSolenoid.set(true);
    }
}

