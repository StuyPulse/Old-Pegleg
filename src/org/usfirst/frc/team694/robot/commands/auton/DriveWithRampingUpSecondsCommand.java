package org.usfirst.frc.team694.robot.commands.auton;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveWithRampingUpSecondsCommand extends Command {
	
	double targetTime;
	double targetSpeed;
	
	double startTime;
	
    public DriveWithRampingUpSecondsCommand(double targetSpeed, double targetTime) {
    		this.targetSpeed = targetSpeed;
    		this.targetTime = targetTime;
        requires(Robot.drivetrain);        
    }

    protected void initialize() {
    		Robot.drivetrain.setRamp(2);;
    		startTime = Timer.getFPGATimestamp();
    	}

    protected void execute() {
    		Robot.drivetrain.arcadeDrive(targetSpeed, 0);
    }

    protected boolean isFinished() {
    		return (Timer.getFPGATimestamp() - startTime >= targetTime);
    }

    protected void end() {
    		Robot.drivetrain.arcadeDrive(0, 0);
    }
    
}
