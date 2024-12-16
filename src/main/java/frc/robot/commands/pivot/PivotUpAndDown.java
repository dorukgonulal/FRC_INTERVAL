package frc.robot.commands.pivot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class PivotUpAndDown extends Command{

    private PivotSubsystem pivotSubsystem;
    private VisionSubsystem visionSubsytem;
    private FeederSubsystem feederSubsystem;
    private IntakeSubsystem intakeSubsystem;

    public PivotUpAndDown(PivotSubsystem pivotSubsystem, VisionSubsystem visionSubsystem) {
        this.pivotSubsystem = pivotSubsystem;
        this.visionSubsytem = visionSubsystem;

        if(visionSubsystem.getTargetDistance()>=400 && visionSubsystem.getTargetDistance()<=500 ) {
            pivotSubsystem.setDistance(-1);
            new ParallelCommandGroup(
                intakeSubsystem.intakeShoot(0.5);
                
            );
        } else if(visionSubsystem.getTargetDistance()>=400 && visionSubsystem.getTargetDistance()<=500 ) {
            pivotSubsystem.setDistance(-1);
        } else if(visionSubsystem.getTargetDistance()>=400 && visionSubsystem.getTargetDistance()<=500 ) {
            pivotSubsystem.setDistance(-1);
        }
    }
    
}
