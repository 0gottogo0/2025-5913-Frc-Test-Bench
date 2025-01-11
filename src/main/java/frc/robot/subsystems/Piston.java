// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import static edu.wpi.first.units.Units.Value;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Piston extends SubsystemBase {
  /** Creates a new Piston. */

  private DoubleSolenoid piston1 = new DoubleSolenoid(Constants.kPistonModule, PneumaticsModuleType.REVPH, 
      Constants.kPiston1In, Constants.kPiston1Out);
  private DoubleSolenoid piston2 = new DoubleSolenoid(Constants.kPistonModule, PneumaticsModuleType.REVPH, 
      Constants.kPiston2In, Constants.kPiston2Out);

  public Piston() {
    piston1.set(DoubleSolenoid.Value.kReverse);
    piston2.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void set(boolean out) {
    if (out) {
      piston1.set(DoubleSolenoid.Value.kForward);
      piston2.set(DoubleSolenoid.Value.kForward);
    } else {
      piston1.set(DoubleSolenoid.Value.kReverse);
      piston2.set(DoubleSolenoid.Value.kReverse);
    }
  }
}
