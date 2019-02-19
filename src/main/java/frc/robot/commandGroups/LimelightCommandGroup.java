/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.command.VisionDrive;
import frc.robot.command.DriveDistanceTimeCommand;
import frc.robot.command.HatchDownTimedCommand;
import frc.robot.command.WaitCommand;

public class LimelightCommandGroup extends CommandGroup {
  
  public static final int L1 = 0;
  public static final int L2 = 1;

  public static final int LEFT = 0;
  public static final int CENTER = 1;
  public static final int RIGHT = 2;

  public LimelightCommandGroup(int level, int position) {
    if (level == L2) {
      addSequential(new DriveDistanceTimeCommand(0.5, 0.5));
      addSequential(new WaitCommand(0.5));
    }
    int pipeline;
    switch (position) {
      case LEFT:
        pipeline = 6;
        break;
      default:
        pipeline = 7;
        break;
    }
    addSequential(new VisionDrive(pipeline));
    addSequential(new HatchDownTimedCommand(1, 0.4));
  }
}
