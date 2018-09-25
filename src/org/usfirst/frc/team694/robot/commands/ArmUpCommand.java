package org.usfirst.frc.team694.robot.commands;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ArmUpCommand extends InstantCommand {

    public ArmUpCommand() {
        requires(Robot.arm);
    }

    protected void initialize() {
    		Robot.arm.up();
    }
}
