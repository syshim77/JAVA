package Exercise;
import java.util.*;

public class Rectangle {
  private double height;
  private double width;

  public Rectangle() {
    this(1.0, 1.0);
  }
  
  public Rectangle(double theHeight, double theWidth) {
    setHeight(theHeight);
    setWidth(theWidth);
  }

  public void setHeight(double theHeight) {
    if (theHeight > 0.0 && theHeight < 20.0)
      height = theHeight;
    else
      throw new IllegalArgumentException("height is out of range");
  }

  public void setWidth(double theWidth) {
    if (theWidth > 0 && theWidth < 20.0)
      width = theWidth;
    else
      throw new IllegalArgumentException("width is out of range");
  }

  public double getPerimeter() {
    return 2 * height + 2 * width;
  }

  public double getArea() {
    return height * width;
  }

  public String toString() {
    return String.format("%s: %f\n%s: %f\n%s: %f\n%s: %f", "Height", height, "Width", width, "Premeter", getPerimeter(),
        "Area", getArea());
  }
}
