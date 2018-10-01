package org.usfirst.frc.team694.robot.commands.auton;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnForSecondsCommand extends Command {
	
	double time;
	
	double startTime;
	
	double leftSpeed;
	double rightSpeed;

    public TurnForSecondsCommand(double leftSpeed, double rightSpeed, double time) {
    	this.leftSpeed = leftSpeed;
    	this.rightSpeed = rightSpeed;
        this.time = time;
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    	startTime = Timer.getFPGATimestamp();
    }

    protected void execute() {
    		Robot.drivetrain.tankDrive(leftSpeed, rightSpeed);
    		
    }

    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - startTime >= time;
    }

    protected void end() {
    		Robot.drivetrain.tankDrive(0, 0);
    }
}
