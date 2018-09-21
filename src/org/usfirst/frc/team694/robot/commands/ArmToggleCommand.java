package org.usfirst.frc.team694.robot.commands;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ArmToggleCommand extends InstantCommand {

    public ArmToggleCommand() {
        requires(Robot.arm);
    }

    protected void initialize() {
    		if (Robot.arm.isOpen) {
    			Robot.arm.close();
    		} else {
    			Robot.arm.open();
    		}
    		Robot.arm.isOpen = !(Robot.arm.isOpen);
    }

}
