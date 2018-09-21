package org.usfirst.frc.team694.robot.commands;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DrivetrainDriveCommand extends Command {

    public DrivetrainDriveCommand() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    		double rightJoystickX = Robot.oi.driverGamepad.getRightX();
    		double leftJoystickY = Robot.oi.driverGamepad.getLeftY();
    		
    		Robot.drivetrain.arcadeDrive(leftJoystickY, rightJoystickX);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
