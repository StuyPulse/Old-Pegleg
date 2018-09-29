package org.usfirst.frc.team694.robot.commands.auton;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnForSecondsCommand extends Command {
	
	double startTime = Timer.getFPGATimestamp();
	double speed;
	double time;
	
	double leftSpeed;
	double rightSpeed;

    public TurnForSecondsCommand(double leftSpeed, double rightSpeed) {
    	this.leftSpeed = leftSpeed;
    	this.rightSpeed = rightSpeed;
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    		Robot.drivetrain.tankDrive(leftSpeed, rightSpeed);
    		
    }

    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - startTime >= time;
    }

    protected void end() {
    		Robot.drivetrain.arcadeDrive(0, 0);
    }
}
