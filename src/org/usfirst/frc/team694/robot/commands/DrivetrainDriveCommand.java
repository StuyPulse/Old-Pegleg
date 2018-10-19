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
    		double rightJoystickXSquared = Math.signum(rightJoystickX) * Math.pow(rightJoystickX, 2);
    		double leftJoystickYSquared = Math.signum(leftJoystickY) * Math.pow(leftJoystickY, 2);
    		boolean quickTurn = false;
    		if (leftJoystickY >= -0.3 || leftJoystickY <= 0.3) {
    			quickTurn = true;
    		}
    		Robot.drivetrain.curvatureDrive(leftJoystickY, rightJoystickX, quickTurn);
    }

  
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
