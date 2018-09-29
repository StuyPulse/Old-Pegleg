package org.usfirst.frc.team694.robot.commands;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ArmDownCommand extends InstantCommand {

    public ArmDownCommand() {
        requires(Robot.arm);
    }
    
    @Override
    protected void initialize() {
    		Robot.arm.down();
    		System.out.println("Moving down");
    }

}
