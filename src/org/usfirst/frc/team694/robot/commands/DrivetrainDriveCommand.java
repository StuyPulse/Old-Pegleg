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
    		double leftJoystickX = Robot.oi.driverGamepad.getLeftX();
    		double leftTrigger = - Robot.oi.driverGamepad.getRawLeftTriggerAxis();
    		double rightTrigger = Robot.oi.driverGamepad.getRawRightTriggerAxis();
    		double leftJoystickXSquared = Math.signum(leftJoystickX) * Math.pow(leftJoystickX, 2);
    		double leftTriggerSquared = Math.signum(leftTrigger) * Math.pow(leftTrigger, 2);
    		double rightTriggerSquared = Math.signum(rightTrigger) * Math.pow(rightTrigger, 2);
    		double straightSpeed = leftTriggerSquared + rightTriggerSquared;
    		boolean quickTurn = false;
    		if (straightSpeed >= -0.3 || straightSpeed <= 0.3) {
    			quickTurn = true;
    		}
    		Robot.drivetrain.curvatureDrive(straightSpeed, leftJoystickXSquared, quickTurn);
    }

  
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
