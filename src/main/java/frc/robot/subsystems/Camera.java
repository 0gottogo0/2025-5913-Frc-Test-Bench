// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.LimelightHelpers;

public class Camera extends SubsystemBase {

  public static final String limeLight = "limelight";

  /** Creates a new Camera. */
  public Camera() {}

  // FIXME Add a PID controller
  public static double moveInput() {
      double tx = LimelightHelpers.getTX(limeLight) / 10; // Get April Tag X
      return tx;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("Target X", moveInput());
  }
}
