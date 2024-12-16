package frc.robot.commands.MultiSubsystem;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.elevator.ElevatorControlCommand;
import frc.robot.commands.pivot.PivotControlCommand;
import frc.robot.commands.pivot.PivotDynamicControlCommand;
import frc.robot.commands.pivot.PivotHoldCommand;
import frc.robot.subsystems.PivotSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class AutoAim  extends SequentialCommandGroup {

    private PivotSubsystem pivotSubsystem;
    private VisionSubsystem visionSubsystem;

    private double pivotHoldPower;

    public AutoAim(PivotSubsystem pivotSubsystem, VisionSubsystem visionSubsystem, double pivotHoldPower){

        this.pivotSubsystem = pivotSubsystem;
        this.visionSubsystem = visionSubsystem;
        this.pivotHoldPower = pivotHoldPower;

        addRequirements(pivotSubsystem, visionSubsystem);

        addCommands( 
                new PivotDynamicControlCommand(pivotSubsystem, visionSubsystem),
                new PivotHoldCommand(pivotSubsystem, pivotHoldPower)
        );
    }
}
