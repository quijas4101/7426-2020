package frc.robot.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.util.*;

public class ColorSensor {
  private static final I2C.Port i2cPort = I2C.Port.kOnboard;

  private static final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  private static final ColorMatch m_colorMatcher = new ColorMatch();

  private static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
  private static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
  private static final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
  private static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);

  public static void Initialize() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
  }
  public static double GetR() {
    Color detectedColor = m_colorSensor.getColor();
    return detectedColor.red;
  }
  public static double GetG() {
    Color detectedColor = m_colorSensor.getColor();
    return detectedColor.green;
  }
  public static double GetB() {
    Color detectedColor = m_colorSensor.getColor();
    return detectedColor.blue;
  }
  public static double GetIR() {
    return m_colorSensor.getIR();
  }
  public static int GetProximity() {
    return m_colorSensor.getProximity();
  }
  public static String GetClosestColor() {
    Color detectedColor = m_colorSensor.getColor();
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }

    return colorString;
  }
}