package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.*;
import com.revrobotics.CANEncoder.*;

public class Shooter {
  private static CANSparkMax ShMotor1 = new CANSparkMax(11, MotorType.kBrushless);
  private static CANSparkMax ShMotor2 = new CANSparkMax(10, MotorType.kBrushless);

  private static SpeedControllerGroup ShooterObj = new SpeedControllerGroup(ShMotor1, ShMotor2);

  public static void Initialize() {
    ShMotor1.setInverted(true);
    ShMotor2.setInverted(false);
    ShMotor2.restoreFactoryDefaults();
    ShMotor1.restoreFactoryDefaults();
  }

  public static void SetPower(boolean Enabled, double Power) {
    if (Enabled) {
      ShooterObj.set(((-Power)+1)/2);
    } else {
      ShooterObj.set(0);
    }
  }

  /*//
private static CANSparkMax ShMotor1 = new CANSparkMax(11, MotorType.kBrushless);
  private static CANSparkMax ShMotor2 = new CANSparkMax(10, MotorType.kBrushless);

  private static SpeedControllerGroup ShooterObj = new SpeedControllerGroup(ShMotor1, ShMotor2);

  public static void Initialize() {
    ShMotor1.setInverted(true);
    ShMotor2.setInverted(false);
  }

  public static void SetPower(boolean Enabled, double Power) {
    if (Enabled) {
      ShooterObj.set(((-Power)+1)/2);
    } else {
      ShooterObj.set(0);
    }
  }
  //*/
}