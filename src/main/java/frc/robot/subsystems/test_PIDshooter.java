package frc.robot.subsystems;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.*;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.*;
import com.revrobotics.CANEncoder.*;

public class Shooter {
  public static final int[] SHOOTER_CAN = {11, 10};
 CANSparkMax[] shooter_motors = new CANSparkMax[] {
    new CANSparkMax(PortMap.SHOOTER_CAN[0], MotorType.kBrushless),
    new CANSparkMax(PortMap.SHOOTER_CAN[1], MotorType.kBrushless),
  };
  private static CANEncoder encoder;
 //pivate static CANEncoder encoder2;
  private static SpeedControllerGroup ShooterObj = new SpeedControllerGroup(shooter_motors[0], shooter_motors[1]);
  private  CANPIDController controller;
//private CANPIDController pidController2;
  public double kMaxOutput, kMinOutput, maxRPM;
  public double shoot_speed = 1.0;

  public static void Initialize() {
    shooter_motors[0].setInverted(true);
   shooter_motors[1].setInverted(false);
    shooter_motors[0].restoreFactoryDefaults();
    shooter_motors[1].restoreFactoryDefaults();
    

    
    kMaxOutput = 1; 
    kMinOutput = 0;
    maxRPM = 5800;
    double setpoint = 0; // maybe try shoot_speed*maxRPM
  }
  
   

  public Shooter() {
      shooter_motors[1].follow(shooter_motors[0], true);
      shooter_motors[0].set(0);

      for ( CANSparkMax motor : shooter_motors ) {
          motor.setIdleMode(IdleMode.kCoast);
      }
      encoder = shooter_motors[0].getEncoder();
      controller = shooter_motors[0].getPIDController();
      controller.setFeedbackDevice(encoder);
      stop();
      updateConstants();
  }

  public void set(double setpoint) {
   SmartDashboard.putNumber("shooterSetpoint", Math.abs(setpoint));
    controller.setReference(setpoint, ControlType.kVelocity);
  }

  public void stop() {
    controller.setReference(0, ControlType.kDutyCycle);
  }

  public void update() {
    SmartDashboard.putNumber("shooterVelocity", Math.abs(encoder.getVelocity()));
  }

  public void updateConstants() {
    controller.setOutputRange(kMaxOutput, kMinOutput);
    controller.setP(constants.shooterP);
    controller.setI(constants.shooterI);
    controller.setD(constants.shooterD);
    controller.setFF(constants.shooterF);
  }
  
    /*if (Enabled) {
      ShooterObj.set(((-Power)+1)/2);
    } else {
      ShooterObj.set(0);
    }*/
  }

}
