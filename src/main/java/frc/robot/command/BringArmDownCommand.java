/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.command;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class BringArmDownCommand extends Command {

  double encoderThreshold;
  double armSpeed;
  public BringArmDownCommand(double in, double armSpeed) {
    requires(Robot.cargoCollector);
    encoderThreshold = in;
    this.armSpeed = armSpeed;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.cargoCollector.resetEncoders();
    System.out.println("Running Auto Arm Down Command at threshold of " + encoderThreshold);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.cargoCollector.setArticulatorPower(armSpeed);
    Robot.drive.cheesyDriveWithoutJoysticks(-0.6, 0);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (Robot.cargoCollector.getArticulatorAEncoder() < encoderThreshold);// || (Robot.cargoCollector.getArticulatorBEncoder() < encoderThreshold);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.cargoCollector.setArticulatorPower(0);
    System.out.println("Ended auto Bring Arm Down Command");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
