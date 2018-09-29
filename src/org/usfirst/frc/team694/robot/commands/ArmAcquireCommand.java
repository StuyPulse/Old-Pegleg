package org.usfirst.frc.team694.robot.commands;

import org.usfirst.frc.team694.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**`
 *
 */
public class ArmAcquireCommand extends Command {

    public ArmAcquireCommand() {
        requires(Robot.arm);
    }

    protected void initialize() {
    }

    protected void execute() {
    		Robot.arm.acquire();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    		Robot.arm.stop();
    }	

    protected void interrupted() {
    	Robot.arm.stop();
    }
}
