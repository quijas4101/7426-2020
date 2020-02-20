package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;

public class Pneumatics {
  private static Solenoid Solenoid1 = new Solenoid(12, 0);

  public static void MovePiston(boolean Enabled) {
    Solenoid1.set(Enabled);
  }
}