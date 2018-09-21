package org.usfirst.frc.team694.robot.commands;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArmDeacquireCommand extends Command {

    public ArmDeacquireCommand() {
        requires(Robot.arm);
    }

    protected void initialize() {
    }

    protected void execute() {
    		Robot.arm.deacquire();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
