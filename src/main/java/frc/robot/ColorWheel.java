package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;

public class ColorWheel {
  private static WPI_VictorSPX ColorWheelMotor = new WPI_VictorSPX(9);

  public static void InitializeAutonomous() {
    ColorWheelMotor.setSafetyEnabled(false);
  }   

  public static void TerminateAutonomous() {
    ColorWheelMotor.setSafetyEnabled(true);
  }

  public static void SetPower(double Power) {
    ColorWheelMotor.set(Power); 
  }
}