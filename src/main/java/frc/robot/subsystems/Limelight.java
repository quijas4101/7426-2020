package frc.robot.subsystems;

import edu.wpi.first.networktables.*;

public class Limelight {
  public static NetworkTable Limelight = NetworkTableInstance.getDefault().getTable("limelight");

  public static boolean TargetsDetected() {
    return Limelight.getEntry("tv").getDouble(0) == 1;
  }

  public static double getOffset(String Axis) {
    if (Axis == "Horizontal" || Axis == "horizontal" || Axis == "tx" || Axis == "x") {
      return Limelight.getEntry("tx").getDouble(0);
    } else if (Axis == "Vertical" || Axis == "vertical" || Axis == "ty" ||  Axis == "y") {
      return Limelight.getEntry("ty").getDouble(0);
    } else {
      return 0;
    }
  }
  public static double getArea() {
    return Limelight.getEntry("ta").getDouble(0);
  }
  public static double getSkew() {
    return Limelight.getEntry("ts").getDouble(0);
  }
  public static double getSide(String Side) {
    if (Side == "Horizontal" || Side == "horizontal" || Side == "x") {
      return Limelight.getEntry("thor").getDouble(0);
    } else if (Side == "Vertical" || Side == "vertical" || Side == "y") {
      return Limelight.getEntry("tvert").getDouble(0);
    } else if (Side == "Shortest" || Side == "shortest" || Side == "Short" || Side == "short") {
      return Limelight.getEntry("tshort").getDouble(0);
    } else if (Side == "Longest" || Side == "longest" || Side == "Long" || Side == "long") {
      return Limelight.getEntry("tlong").getDouble(0);
    } else {
      return 0;
    }
  }
  public static double getPipeline() {
    return Limelight.getEntry("getpipe").getDouble(0);
  }
  public static double getValue(String Value) {
    return Limelight.getEntry(Value).getDouble(0);
  }

  public static void setLED(String Mode) {
    if (Mode == "Default" || Mode == "default") {
      Limelight.getEntry("ledMode").setDouble(0);
    } else if (Mode == "Off" || Mode == "off") {
      Limelight.getEntry("ledMode").setDouble(1);
    } else if (Mode == "Blink" || Mode == "blink") {
      Limelight.getEntry("ledMode").setDouble(2);
    } else if (Mode == "On" || Mode == "on") {
      Limelight.getEntry("ledMode").setDouble(3);
    }
  }
  public static void setCameraMode(String Mode) {
    if (Mode == "Default" || Mode == "default" || Mode == "Tracking" || Mode == "tracking") {
      Limelight.getEntry("camMode").setDouble(0);
    } else if (Mode == "Camera" || Mode == "camera" || Mode == "Driver" || Mode == "driver") {
      Limelight.getEntry("camMode").setDouble(1);
    }
  }
  public static void setPipeline(double Pipeline) {
    Limelight.getEntry("pipeline").setDouble(Pipeline);
  }
  public static void setStreamMode(String Mode) {
    if (Mode == "Standard" || Mode == "standard" || Mode == "Default" || Mode == "default") {
      Limelight.getEntry("stream").setDouble(0);
    } else if (Mode == "Primary" || Mode == "primary") {
      Limelight.getEntry("stream").setDouble(1);
    } else if (Mode == "Secondary" || Mode == "secondary") {
      Limelight.getEntry("stream").setDouble(2);
    }
  }
  public static void setSnapshot(String Mode) {
    if (Mode == "Off" || Mode == "off" || Mode == "False" || Mode == "false") {
      Limelight.getEntry("snapshot").setDouble(0);
    } else if (Mode == "On" || Mode == "on" || Mode == "True" || Mode == "true") {
      Limelight.getEntry("snapshot").setDouble(1);
    }
  }
  public static void setValue(String Value, double Mode) {
    Limelight.getEntry(Value).setDouble(Mode);
  }
}
