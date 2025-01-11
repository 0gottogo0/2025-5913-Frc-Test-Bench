// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {

  private TalonFX arm = new TalonFX(Constants.kElevetorMotor);

  private TalonFXConfiguration cfg = new TalonFXConfiguration();

  private double armSetpoint;

  public Arm() {
    cfg.MotorOutput.NeutralMode = NeutralModeValue.Brake;

    arm.clearStickyFaults();
  
    arm.getConfigurator().apply(cfg);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("Arm Pos", arm.getPosition().getValueAsDouble());
  }

  public void positive(double percentOutput) {
    arm.set(percentOutput);
  }

  public void negative(double percentOutput) {
    arm.set(-percentOutput);
  }

  public void stop() {
    arm.set(0);
  }
}