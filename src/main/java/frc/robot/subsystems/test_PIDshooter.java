package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.*;
import com.revrobotics.CANEncoder.*;

public class Shooter {
  private static CANSparkMax ShMotor1 = new CANSparkMax(11, MotorType.kBrushless);
  private static CANSparkMax ShMotor2 = new CANSparkMax(10, MotorType.kBrushless);
  private static CANEncoder m_encoder;
  private static CANEncoder m_encoder2;
  private static SpeedControllerGroup ShooterObj = new SpeedControllerGroup(ShMotor1, ShMotor2);
  private CANPIDController m_pidController;
  private CANPIDController m_pidController2;
  public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM;

  public static void Initialize() {
    ShMotor1.setInverted(true);
    ShMotor2.setInverted(false);
    ShMotor2.restoreFactoryDefaults();
    ShMotor1.restoreFactoryDefaults();
    
     m_encoder = ShMotor1.getEncoder();
     //m_encoder2 = ShMotor2.getEncoder();
     m_pidController = ShMotor1.getPIDController();
    m_pidController2 = ShMotor2.getPIDController();
    
    kP = 6e-5; 
    kI = 0;
    kD = 0; 
    kIz = 0; 
    kFF = 0.000015; 
    kMaxOutput = 1; 
    kMinOutput = -1;
    maxRPM = 5800;

    // set PID coefficients
    m_pidController.setP(kP);
    m_pidController.setI(kI);
    m_pidController.setD(kD);
    m_pidController.setIZone(kIz);
    m_pidController.setFF(kFF);
    m_pidController.setOutputRange(kMinOutput, kMaxOutput);
    
    m_pidController2.setP(kP);
    m_pidController2.setI(kI);
    m_pidController2.setD(kD);
    m_pidController2.setIZone(kIz);
    m_pidController2.setFF(kFF);
    m_pidController2.setOutputRange(kMinOutput, kMaxOutput);
    
    // display PID coefficients on SmartDashboard
    SmartDashboard.putNumber("P Gain", kP);
    SmartDashboard.putNumber("I Gain", kI);
    SmartDashboard.putNumber("D Gain", kD);
    SmartDashboard.putNumber("I Zone", kIz);
    SmartDashboard.putNumber("Feed Forward", kFF);
    SmartDashboard.putNumber("Max Output", kMaxOutput);
    SmartDashboard.putNumber("Min Output", kMinOutput);
  }
  }


  public static void SetPower(boolean Enabled, double Power) {
    
      // read PID coefficients from SmartDashboard
    double p = SmartDashboard.getNumber("P Gain", 0);
    double i = SmartDashboard.getNumber("I Gain", 0);
    double d = SmartDashboard.getNumber("D Gain", 0);
    double iz = SmartDashboard.getNumber("I Zone", 0);
    double ff = SmartDashboard.getNumber("Feed Forward", 0);
    double max = SmartDashboard.getNumber("Max Output", 0);
    double min = SmartDashboard.getNumber("Min Output", 0);

    // if PID coefficients on SmartDashboard have changed, write new values to controller
    if((p != kP)) { m_pidController.setP(p);  m_pidController2.setP(p); kP = p; }
    if((i != kI)) { m_pidController.setI(i); m_pidController2.setI(i); kI = i; }
    if((d != kD)) { m_pidController.setD(d);  m_pidController2.setD(d) kD = d; }
    if((iz != kIz)) { m_pidController.setIZone(iz); m_pidController2.setIZone(iz); kIz = iz; }
    if((ff != kFF)) { m_pidController.setFF(ff); m_pidController2.setFF(ff); kFF = ff; }
    if((max != kMaxOutput) || (min != kMinOutput)) { 
      m_pidController.setOutputRange(min, max);    m_pidController2.setOutputRange(min, max);
      kMinOutput = min; kMaxOutput = max; 
    }
     double setPoint = Power*maxRPM;
    m_pidController.setReference(setPoint, ControlType.kVelocity);
    m_pidController2.setReference(setPoint, ControlType.kVelocity);
    
    SmartDashboard.putNumber("SetPoint", setPoint);
    SmartDashboard.putNumber("ProcessVariable", m_encoder.getVelocity());

    /*if (Enabled) {
      ShooterObj.set(((-Power)+1)/2);
    } else {
      ShooterObj.set(0);
    }*/
  }

}
