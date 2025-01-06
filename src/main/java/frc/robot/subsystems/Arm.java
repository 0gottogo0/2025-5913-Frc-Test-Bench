// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */

  private TalonFX arm = new TalonFX(1);

  // private CANcoder pivotEncoder = new CANcoder(Constants.pivotEncoderID);

  private DutyCycleEncoder armEncoder = new DutyCycleEncoder(2);

  private TalonFXConfiguration cfg = new TalonFXConfiguration();

  // www.reca.lc shall not tell you the holy truth of the universe, however it shall be good enough...

  // private ArmFeedforward feedforward = new ArmFeedforward(kS, kG, kV, kA);

  private double armSetpoint;

  public Arm() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void positive(double percentOutput) {
    arm.set(percentOutput);
  }

  public void negitive(double percentOutput) {
    arm.set(-percentOutput);
  }

  public void stop() {
    arm.set(0);
  }

  public void setAim90() {
    armSetpoint = 90;
  }

  public void setAim45() {
    armSetpoint = 45;
  }

  public void setAim165() {
    armSetpoint = 165;
  }

  public void setAimNegitive90() {
    armSetpoint = -90;
  }

  public void setAimNegitive45() {
    armSetpoint = -45;
  }
}
