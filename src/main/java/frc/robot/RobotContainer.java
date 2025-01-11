// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.Piston;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

      public final Arm arm = new Arm();
      public final Camera camera = new Camera();
      public final Piston piston = new Piston();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    driverController.b().whileTrue(arm.runEnd(
      () -> arm.positive(0.1),
      () -> arm.stop()));
  
    driverController.a().whileTrue(arm.runEnd(
      () -> arm.negative(-0.1),
      () -> arm.stop()));

    driverController.x().whileTrue(arm.runEnd(
      () -> arm.positive(MathUtil.clamp(Camera.moveInput(), -Constants.kElevetorSpeedMax, Constants.kElevetorSpeedMax)),
      () -> arm.stop()));

    driverController.y().whileTrue(piston.runEnd(
      () -> piston.set(true),
      () -> piston.set(false)));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
