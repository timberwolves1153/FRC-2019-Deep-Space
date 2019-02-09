package frc.robot.command;

import frc.robot.Robot;
import frc.robot.subsytems.LimelightVision.Target;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class VisionDrive extends Command {



	private static final double H1 = 24;   //camera height
	private static final double H2 = 28.5;   //target height
	private static final double A1 = 0;   //camera angle

	private double lidarStopDistance;
	
	boolean bApproachedTarget = false;
	long startTime;

	static int  pipeLine = 1; 

	double distanceToSwitch;
	double distanceFromSwitch;
	double distance;

	
    public VisionDrive(int pipelineNumber) {
        requires(Robot.drive);
		requires(Robot.vision);
		
		pipeLine = pipelineNumber;
    }

    protected void initialize() {
    	System.out.println("Vision ENABLED");
    	startTime = System.currentTimeMillis();
		Robot.vision.turnOnLight();
    	Robot.vision.setPipeline(pipeLine);
    }
    

    protected void execute() {
		Target target = Robot.vision.getTargetValues();
		if (target != null) {
			Robot.drive.cheesyDriveWithoutJoysticks(-0.6, Robot.vision.getHorizontalAlignOutput() * -1);
			System.out.println("Executing Limelight vision");

		} else {
			Robot.drive.cheesyDriveWithoutJoysticks(0, 0);
		}

    }

    protected boolean isFinished() {



		/**
		boolean rightMotorsStopped = Math.abs(Robot.autoDrive.getRightMotorOutputPercent()) < 0.02;
		boolean leftMotorsStopped = Math.abs(Robot.autoDrive.getLeftMotorOutputPercent()) < 0.02;

		return rightMotorsStopped && leftMotorsStopped;
		
		if (Robot.lidar.distance(false) < lidarStopDistance) {
			return true;
		} else {
			return false;
		}
		*/

		return false;
    }

    protected void end() {
    }


    protected void interrupted() {
	}
	
	/**
	 * See the below diagram. 
	 * In this situation all of the variables are known: the height of the target (h2) is known because it is a property of the field. 
	 * The height of your camera above the floor (h1) is known and its mounting angle is known (a1). 
	 * The limelight (or your vision system) can tell you the y angle to the target (a2).
	 */
	public static double findDistance(double h1, double h2, double a1, double a2)  {
		return ((h2-h1) / (Math.tan(Math.toRadians(a1+a2))));
	}

}