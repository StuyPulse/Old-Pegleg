package org.usfirst.frc.team694.robot.commands.auton.choosers;

import org.usfirst.frc.team694.robot.Robot;
import org.usfirst.frc.team694.robot.commands.auton.routines.DifferentSideSwitchAutonCommand;
import org.usfirst.frc.team694.robot.commands.auton.routines.SameSideSwitchAutonCommand;

import edu.wpi.first.wpilibj.command.ConditionalCommand;

/**
 *
 */
public class SingleSwitchAutonChooserCommand extends ConditionalCommand {

    public SingleSwitchAutonChooserCommand() {
        super(new SameSideSwitchAutonCommand(), new SingleDifferentSwitchAutonChooserCommand());
    }

    @Override
    public boolean condition() {
        return Robot.isRobotOnSameSideSwitch();
    }

    private static class SingleDifferentSwitchAutonChooserCommand extends ConditionalCommand {
        public SingleDifferentSwitchAutonChooserCommand() {
            super(new DifferentSideSwitchAutonCommand(true), new DifferentSideSwitchAutonCommand(false));
        }

        @Override
        public boolean condition() {
            return Robot.isRobotStartingOnRight();
        }
    }
}
