package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.drive.*;
//import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;

public class Drive {
  private static WPI_TalonSRX Drive_L1 = new WPI_TalonSRX(0);
  private static WPI_VictorSPX Drive_L2 = new WPI_VictorSPX(1);
  private static WPI_VictorSPX Drive_L3 = new WPI_VictorSPX(2);
  private static WPI_TalonSRX Drive_R1 = new WPI_TalonSRX(3);
  private static WPI_VictorSPX Drive_R2 = new WPI_VictorSPX(4);
  private static WPI_VictorSPX Drive_R3 = new WPI_VictorSPX(5);

  private static SpeedControllerGroup Drive_L = new SpeedControllerGroup(Drive_L1, Drive_L2, Drive_L3);
  private static SpeedControllerGroup Drive_R = new SpeedControllerGroup(Drive_R1, Drive_R2, Drive_R3);

  private static DifferentialDrive DriveObj = new DifferentialDrive(Drive_L, Drive_R);

  public static void InitializeFactory() {
    Drive_L1.configFactoryDefault();
    Drive_L2.configFactoryDefault();
    Drive_L3.configFactoryDefault();
    Drive_R1.configFactoryDefault();
    Drive_R2.configFactoryDefault();
    Drive_R3.configFactoryDefault();
  }

  public static void InitializeAutonomous() {
    DriveObj.setSafetyEnabled(false);
  }

  public static void TerminateAutonomous() {
    DriveObj.setSafetyEnabled(true);
  }

  public static void DriveHandler(double FB, double LR) {
    DriveObj.arcadeDrive(FB, LR);
  }
}