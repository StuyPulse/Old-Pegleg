package org.usfirst.frc.team694.robot.commands.auton.routines;

import org.usfirst.frc.team694.robot.commands.ArmDeacquireCommand;
import org.usfirst.frc.team694.robot.commands.ArmOpenCommand;
import org.usfirst.frc.team694.robot.commands.auton.DriveWithRampingUpSecondsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SameSideSwitchAutonCommand extends CommandGroup {

    public SameSideSwitchAutonCommand() {
        addSequential(new DriveWithRampingUpSecondsCommand(0.5, 10));
        addParallel(new ArmDeacquireCommand());
        addSequential(new ArmOpenCommand());
    }
}
