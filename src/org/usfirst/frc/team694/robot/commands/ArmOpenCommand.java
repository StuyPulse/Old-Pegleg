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

    @Override
    protected void initialize() {
    		Robot.arm.open();
    		System.out.println("Opening");
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
