package org.usfirst.frc.team694.robot.commands;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ArmOpenCommand extends InstantCommand {

    public ArmOpenCommand() {
        requires(Robot.arm);
    }

    protected void initialize() {
    		Robot.arm.open();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
