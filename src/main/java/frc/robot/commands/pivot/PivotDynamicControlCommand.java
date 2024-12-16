package frc.robot.commands.pivot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Constants;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.VisionSubsystem;


public class PivotDynamicControlCommand extends Command {

  private PivotSubsystem pivotSubsystem;
  private VisionSubsystem visionSubsystem;
  private double goalPos;
  private double error;

  private double PIVOT_POWER = Constants.PivotConstants.PIVOT_POWER;

  public PivotDynamicControlCommand(PivotSubsystem pivotSubsystem, VisionSubsystem visionSubsystem) {

    this.pivotSubsystem = pivotSubsystem;
    this.visionSubsystem = visionSubsystem;
    
    addRequirements(pivotSubsystem, visionSubsystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    goalPos = (visionSubsystem.getTargetDistance()) * Constants.LimelightConstants.DISTANCE_CONSTRAINT ;

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
 
      error = (goalPos - pivotSubsystem.getEncoderPosition());


      if (Math.abs(error) > Constants.PivotConstants.PIVOT_KP) {

        double power = Constants.PivotConstants.PIVOT_KP * error;

        if (Math.abs(power) > PIVOT_POWER) {

          power = Math.copySign(PIVOT_POWER, power);

        }

        if (Math.abs(power) < 0.1) {

          power = Math.copySign(0.1, power);

        }

        else{

        pivotSubsystem.setPivot(power);

      } 

      }
      
      else {

        pivotSubsystem.pivotStop();

      }

      SmartDashboard.putNumber("Vision Distance Error", error);

    } 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    pivotSubsystem.setPivot(0.04);;

  }

  public boolean isFinished() {
    
    return -0.2 < error && error < 0.2;

  }
}
