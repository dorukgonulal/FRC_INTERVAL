package frc.robot.commands.pivot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class PivotUpAndDown extends Command{

    private PivotSubsystem pivotSubsystem;
    private VisionSubsystem visionSubsytem;
    private FeederSubsystem feederSubsystem;
    private IntakeSubsystem intakeSubsystem;

    public PivotUpAndDown(PivotSubsystem pivotSubsystem, VisionSubsystem visionSubsystem, FeederSubsystem feederSubsystem, IntakeSubsystem intakeSubsystem) {
        this.pivotSubsystem = pivotSubsystem;
        this.visionSubsytem = visionSubsystem;
        this.feederSubsystem = feederSubsystem;
        this.intakeSubsystem = intakeSubsystem;

        
        addRequirements(pivotSubsystem, visionSubsystem, intakeSubsystem, feederSubsystem);
    }
    
    @Override
    public void initialize() {
        pivotSubsystem.resetEncoder();
    }

    @Override 
    public void execute() {
        double TargetDistance = visionSubsytem.getTargetDistance();

        if(TargetDistance >= 400 && TargetDistance <= 500 ) {
            pivotSubsystem.setDistance(-5);
            intakeSubsystem.intakeOn(0.6);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            feederSubsystem.feedOn(0.7);
            
        } else if (TargetDistance >= 300 && TargetDistance < 400 ) {
            pivotSubsystem.setDistance(-3);
            intakeSubsystem.intakeOn(0.5);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            feederSubsystem.feedOn(0.6);
        } else if (TargetDistance >= 200 && TargetDistance < 300 ) {
            pivotSubsystem.setDistance(-2);
            intakeSubsystem.intakeOn(0.4);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            feederSubsystem.feedOn(0.5);
        } else if (TargetDistance >= 100 && TargetDistance < 200) {
            pivotSubsystem.setDistance(-1);
            intakeSubsystem.intakeOn(0.4);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            feederSubsystem.feedOn(0.4);
        } else if (TargetDistance >= 10 && TargetDistance < 100) {
            pivotSubsystem.setDistance(-1);
            intakeSubsystem.intakeOn(0.4);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            feederSubsystem.feedOn(0.4);
        } else {
            double lastAngle = pivotSubsystem.getEncoderPosition();
            pivotSubsystem.setDistance(-lastAngle);
        }
    }
    
}