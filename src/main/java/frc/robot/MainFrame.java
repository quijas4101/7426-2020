package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class MainFrame {
  // Shuffleboard Data Initialization and Communication
  private static ShuffleboardTab TabConfiguration = Shuffleboard.getTab("Configuration");
  private static ShuffleboardTab TabAutonomous = Shuffleboard.getTab("Autonomous");
  private static ShuffleboardTab TabOperation = Shuffleboard.getTab("Operation");
  private static ShuffleboardTab TabTesting = Shuffleboard.getTab("Testing");

  public static void ChangeTab(String Name) {
    if (Name == "TabConfiguration" || Name == "Configuration") {
      Shuffleboard.selectTab("TabConfiguration");
    } else if (Name == "TabAutonomous" || Name == "Autonomous") {
      Shuffleboard.selectTab("TabAutonomous");
    } else if (Name == "TabOperation" || Name == "Operation") {
      Shuffleboard.selectTab("TabOperation");
    } else if (Name == "TabTesting" || Name == "Testing") {
      Shuffleboard.selectTab("TabTesting");
    }
  }

  public static Object GetValue(String Tab, String Name, Boolean Persistent, Object DefaultValue) {
    if (Tab == "TabConfiguration" || Tab == "Configuration") {
      if (!Persistent) {
        return TabConfiguration.add(Name, DefaultValue).getEntry().getValue().getValue();
      } else {
        return TabConfiguration.addPersistent(Name, DefaultValue).getEntry().getValue().getValue();
      }
    } else if (Tab == "TabAutonomous" || Tab == "Autonomous") {
      if (!Persistent) {
        return TabAutonomous.add(Name, DefaultValue).getEntry().getValue().getValue();
      } else {
        return TabAutonomous.addPersistent(Name, DefaultValue).getEntry().getValue().getValue();
      }
    } else if (Tab == "TabOperation" || Tab == "Operation") {
      if (!Persistent) {
        return TabOperation.add(Name, DefaultValue).getEntry().getValue().getValue();
      } else {
        return TabOperation.addPersistent(Name, DefaultValue).getEntry().getValue().getValue();
      }
    } else if (Tab == "TabTesting" || Tab == "Testing") {
      if (!Persistent) {
        return TabTesting.add(Name, DefaultValue).getEntry().getValue().getValue();
      } else {
        return TabTesting.addPersistent(Name, DefaultValue).getEntry().getValue().getValue();
      }
    }
    return null;
  }

  public static void SetValue(String Tab, String Name, Boolean Persistent, Object DefaultValue, Object Value) {
    if (Tab == "TabConfiguration" || Tab == "Configuration") {
      if (!Persistent) {
        TabConfiguration.add(Name, DefaultValue).getEntry().setValue(Value);
      } else {
        TabConfiguration.addPersistent(Name, DefaultValue).getEntry().setValue(Value);
      }
    } else if (Tab == "TabAutonomous" || Tab == "Autonomous") {
      if (!Persistent) {
        TabAutonomous.add(Name, DefaultValue).getEntry().setValue(Value);
      } else {
        TabAutonomous.addPersistent(Name, DefaultValue).getEntry().setValue(Value);
      }
    } else if (Tab == "TabOperation" || Tab == "Operation") {
      if (!Persistent) {
        TabOperation.add(Name, DefaultValue).getEntry().setValue(Value);
      } else {
        TabOperation.addPersistent(Name, DefaultValue).getEntry().setValue(Value);
      }
    } else if (Tab == "TabTesting" || Tab == "Testing") {
      if (!Persistent) {
        TabTesting.add(Name, DefaultValue).getEntry().setValue(Value);
      } else {
        TabTesting.addPersistent(Name, DefaultValue).getEntry().setValue(Value);
      }
    }
  }

  //Robot Initialization and Control
  public static void Initialize() {
    ColorSensor.Initialize();
    Drive.InitializeFactory();
    Shooter.Initialize();
  }

  public static void Terminate() {}

  public static void InitializeAutonomous() {
    Drive.InitializeAutonomous();
    Accumulator.InitializeAutonomous();
    ColorWheel.InitializeAutonomous();
  }

  public static void TerminateAutonomous() {
    Drive.TerminateAutonomous();
    Accumulator.TerminateAutonomous();
    ColorWheel.TerminateAutonomous();
  }

  public static void Control(XboxController Controller, Joystick Joystick) {
    Drive.DriveHandler(-Controller.getY(Hand.kLeft), Controller.getX(Hand.kRight));
    Accumulator.SetPower(Joystick.getRawButton(11), Joystick.getRawButton(2));
    Shooter.SetPower(Joystick.getTrigger(), Joystick.getThrottle());
    Pneumatics.MovePiston(Joystick.getRawButton(3));
    if (Joystick.getRawButton(12)) {
      ColorWheel.SetPower(1);
    } else {
      ColorWheel.SetPower(0);
    }
  }
  public static void TestControl(XboxController Controller, Joystick Joystick) {
    Drive.DriveHandler(-Controller.getY(Hand.kLeft), Controller.getX(Hand.kRight));
    Accumulator.SetPower(Joystick.getRawButton(11), Joystick.getRawButton(12));
    if(Joystick.getTrigger()){
      shooter.set(Constants.getConstants().debugShooterSet);
    }
    
    
    Pneumatics.MovePiston(Joystick.getRawButton(3));
    if (Joystick.getRawButton(2)) {
      ColorWheel.SetPower(1);
    } else {
      ColorWheel.SetPower(0);
    }
  }
}
