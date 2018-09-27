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

    public TurnForSecondsCommand(double speed, double time) {
    		
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    		Robot.drivetrain.arcadeDrive(0, speed);
    		
    }

    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - startTime >= time;
    }

    protected void end() {
    		Robot.drivetrain.arcadeDrive(0, 0);
    }
}
