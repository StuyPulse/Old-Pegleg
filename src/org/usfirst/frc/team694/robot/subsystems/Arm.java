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
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double getSpeed() {
    		return motor.getSelectedSensorVelocity(0);
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
    		elevationSolenoid.set(true);
    }
    
    public void down() {
    		elevationSolenoid.set(false);
    }
}

