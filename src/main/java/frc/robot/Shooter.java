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
  private static long lastTime;
  private double lastTicks;

  public static void Initialize() {
    ShMotor1.setInverted(true);
    ShMotor2.setInverted(false);
    ShMotor2.restoreFactoryDefaults();
    ShMotor1.restoreFactoryDefaults();
    
     m_encoder = ShMotor1.getEncoder();
     //m_encoder2 = ShMotor2.getEncoder();
  }

  	//Calculate RPM using Java built in timer and Encoder class from WPILIB
	double getRPM(){
		double dt = (System.currentTimeMillis() - lastTime);
		double lastTime = System.currentTimeMillis();
		double currentTicks = m_encode.getPosition();
		double rate = (currentTicks - lastTicks)/dt;
		return (rate * 60 * 1000);	
	}	
  
  public class BangBang implements Loopable {
	  private double m_desiredRPM = 5800; //Random number, you'll have to test for the RPM that works best for you
    
    public static void SetPower(boolean Enabled, double Power) {
     if (Enabled) {
      	if(getRPM() < m_desiredRPM){
			ShooterObj.set(1);
	  	}
	  	else{
			ShooterObj.set(0);
		   }
	  	if(Math.abs(getRPM()-m_desiredRPM)<50){
			///Time to SHOOT
		  }
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
