package org.usfirst.frc.team694.robot.commands.auton.routines;

import org.usfirst.frc.team694.robot.commands.ArmDeacquireCommand;
import org.usfirst.frc.team694.robot.commands.ArmOpenCommand;
import org.usfirst.frc.team694.robot.commands.auton.DriveWithRampingUpSecondsCommand;
import org.usfirst.frc.team694.robot.commands.auton.TurnForSecondsCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DifferentSideSwitchAutonCommand extends CommandGroup {

    public DifferentSideSwitchAutonCommand(boolean isRight) {
        addSequential(new DriveWithRampingUpSecondsCommand(0.5, 2));
        addSequential(new TurnForSecondsCommand(isRight? -0.5 : 0.5, isRight? 0.5 : -0.5, 2));
        addSequential(new DriveWithRampingUpSecondsCommand(0.5, 3));
        addSequential(new TurnForSecondsCommand(isRight? 0.5 : -0.5, isRight? -0.5 : 0.5, 2));
        addSequential(new DriveWithRampingUpSecondsCommand(0.5, 2));
        addParallel(new ArmDeacquireCommand());
        addSequential(new ArmOpenCommand());
    }
}
