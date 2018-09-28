package org.usfirst.frc.team694.robot.commands.auton;

import org.usfirst.frc.team694.robot.Robot;
import org.usfirst.frc.team694.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithRampingUpSecondsCommand extends Command {
	
	double targetTime;
	double targetSpeed;
	
	double startTime;
	
	double speed;
	
	double timePassed;
	
    public DriveWithRampingUpSecondsCommand(double targetSpeed, double targetTime) {
    		this.targetSpeed = targetSpeed;
    		this.targetTime = targetTime;
        requires(Robot.drivetrain);        
    }

    protected void initialize() {
    		startTime = Timer.getFPGATimestamp();
    	}

    protected void execute() {
    		timePassed = Timer.getFPGATimestamp() - startTime;
    		speed = timePassed * RobotMap.DRIVETRAIN_TIME_TO_SPEED_MULTIPLIER;
    		
    		Robot.drivetrain.arcadeDrive(speed, 0);
    }

    protected boolean isFinished() {
    		return (Timer.getFPGATimestamp() - startTime >= targetTime);
    }

    protected void end() {
    		Robot.drivetrain.arcadeDrive(0, 0);
    }
    
}
