package org.usfirst.frc.team694.robot.commands;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivetrainDriveCommand extends Command {

	double rightJoystickY;
	double leftJoystickY;
    public DrivetrainDriveCommand() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    		rightJoystickY = Robot.oi.driverGamepad.getRightY();
    		leftJoystickY = Robot.oi.driverGamepad.getLeftY();
    		
    		Robot.drivetrain.tankDrive(leftJoystickY, rightJoystickY);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
