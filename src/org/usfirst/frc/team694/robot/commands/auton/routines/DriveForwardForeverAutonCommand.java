package org.usfirst.frc.team694.robot.commands.auton.routines;

import org.usfirst.frc.team694.robot.commands.auton.DrivetrainDriveWithRampingSecondsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardForeverAutonCommand extends CommandGroup {

    public DriveForwardForeverAutonCommand() {
        addSequential(new DrivetrainDriveWithRampingSecondsCommand(15, 0.5));
    }
}
