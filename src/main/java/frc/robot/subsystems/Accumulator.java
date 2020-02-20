package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;

public class Accumulator {
  private static WPI_VictorSPX AccMotor = new WPI_VictorSPX(6);
  private static WPI_VictorSPX AccLaunch = new WPI_VictorSPX(7);
  private static WPI_VictorSPX AccMotor2 = new WPI_VictorSPX(20);
  public static void InitializeAutonomous() {
    AccMotor.setSafetyEnabled(false);
    AccLaunch.setSafetyEnabled(false);
    AccMotor2.setSafetyEnabled(false);
  }   

  public static void TerminateAutonomous() {
    AccMotor.setSafetyEnabled(true);
    AccLaunch.setSafetyEnabled(true);
    AccMotor2.setSafetyEnabled(true);
  }

  public static void SetPower(Boolean Power, Boolean Shoot) {
    if (Power || Shoot) {
      AccMotor.set(-1); 
      AccMotor2.set(-1); 
    } else {
      AccMotor.set(0);
      AccMotor2.set(0);
    }
    if (Shoot) {
      AccLaunch.set(-1);
    } else {
      AccLaunch.set(0);
    }
  }
  /*//public static void TogglePower(boolean Power){
    
  }
  //*/
}