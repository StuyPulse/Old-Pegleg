package org.usfirst.frc.team694.robot.commands.auton.routines;

import org.usfirst.frc.team694.robot.commands.auton.DriveWithRampingUpSecondsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardForeverAutonCommand extends CommandGroup {

    public DriveForwardForeverAutonCommand() {
        addSequential(new DriveWithRampingUpSecondsCommand(0.5, 5));
    }
}
