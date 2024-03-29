/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public RobotMap() {

	}

	// Drivetrain Talons/Victors
	public static final int LEFT_MASTER = 1;
	public static final int LEFT_FOLLOWER_1 = 2;
	public static final int LEFT_FOLLOWER_2 = 3;
	public static final int RIGHT_MASTER = 4;
	public static final int RIGHT_FOLLOWER_1 = 5;
	public static final int RIGHT_FOLLOWER_2 = 6;

	// Cargo motor controllers
	public static final int CARGO_TALON_A = 7;
	public static final int CARGO_TALON_B = 8;
	public static final int CARGO_ROLLER = 3;

	public static final int CARGO_ROLLER_TALON = 9;

	// Hatch ground intake motor controllor
	public static final int HATCH_ARTICULATOR = 4;
	public static final int HATCH_ROLLER = 2;

	public static final int HATCH_ARTICULATOR_TALON = 11;
	public static final int HATCH_ROLLER_TALON = 10;

	public static final int LIDAR = 0;

	public static final int CARGO_LIGHT_SENSOR = 3;
	public static final int HATCH_LIMIT_SWITCH_A = 1;
	public static final int HATCH_LIMIT_SWITCH_B = 2;

	//PDP ports to talons

	public static final int DRIVE_ONE = 15;
	public static final int DRIVE_TWO = 14;
	public static final int DRIVE_THREE = 13;
	public static final int DRIVE_FOUR = 2;
	public static final int DRIVE_FIVE = 1;
	public static final int DRIVE_SIX = 0;

}