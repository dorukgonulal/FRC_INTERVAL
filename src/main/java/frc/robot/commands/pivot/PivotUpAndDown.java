package frc.robot.commands.pivot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.commands.intake.IntakeRollerSpeakerShootCommand;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class PivotUpAndDown extends Command{

    private PivotSubsystem pivotSubsystem;
    private VisionSubsystem visionSubsytem;
    private FeederSubsystem feederSubsystem;
    private IntakeSubsystem intakeSubsystem;

    private Timer timer = new Timer();

    public PivotUpAndDown(PivotSubsystem pivotSubsystem, VisionSubsystem visionSubsystem, FeederSubsystem feederSubsystem, IntakeSubsystem intakeSubsystem) {
        this.pivotSubsystem = pivotSubsystem;
        this.visionSubsytem = visionSubsystem;
        this.feederSubsystem = feederSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        
        addRequirements(pivotSubsystem, visionSubsystem, intakeSubsystem, feederSubsystem);
    }

    @Override 
    public void initialize() {
        timer.reset();
    }

    @Override 
    public void execute() {
        double TargetDistance = visionSubsytem.getTargetDistance();

        if(TargetDistance >= 400 && TargetDistance <= 500 ) {
            pivotSubsystem.setDistance(-1);
            intakeSubsystem.intakeOn(0.6);
            
        } else if (TargetDistance >=400 && TargetDistance <=500 ) {
            pivotSubsystem.setDistance(-3);
            intakeSubsystem.intakeOn(0.5);
        } else if (TargetDistance >=400 && TargetDistance <=500 ) {
            pivotSubsystem.setDistance(-5);
            tem.intakeOn(0.4);
        } else {
            
        }
    }
    
}
