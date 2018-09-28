/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team694.robot;

import org.usfirst.frc.team694.robot.commands.ArmAcquireCommand;
import org.usfirst.frc.team694.robot.commands.ArmCloseCommand;
import org.usfirst.frc.team694.robot.commands.ArmDeacquireCommand;
import org.usfirst.frc.team694.robot.commands.ArmDownCommand;
import org.usfirst.frc.team694.robot.commands.ArmOpenCommand;
import org.usfirst.frc.team694.robot.commands.ArmUpCommand;
import org.usfirst.frc.team694.util.Gamepad;
import org.usfirst.frc.team694.util.Gamepad.GamepadSwitchMode;

public class OI {
    public Gamepad driverGamepad;
    public Gamepad operatorGamepad;

    public OI() {
        driverGamepad = new Gamepad(RobotMap.GAMEPAD_DRIVER_PORT, GamepadSwitchMode.SWITCH_D);
        operatorGamepad = new Gamepad(RobotMap.GAMEPAD_OPERATOR_PORT, GamepadSwitchMode.SWITCH_X);

        operatorGamepad.getRightTrigger().whileHeld(new ArmAcquireCommand());
        operatorGamepad.getRightBumper().whileHeld(new ArmDeacquireCommand());
        
        operatorGamepad.getLeftTrigger().whenPressed(new ArmCloseCommand());
        operatorGamepad.getLeftBumper().whenPressed(new ArmOpenCommand());
        
        operatorGamepad.getTopButton().whenPressed(new ArmUpCommand());
        operatorGamepad.getBottomButton().whenPressed(new ArmDownCommand());
    }
}
