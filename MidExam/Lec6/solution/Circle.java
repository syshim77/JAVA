package solution;

public class Circle extends TwoDimensionalShape {
	// constructor
	public Circle(String name, double r) {
		super(name, r, r);
	}

	@Override
	// return current class name
	public String getClassName() {
		return "Circle";
	}

	public double getRadius() {
		return super.getDimension1();
	}

	public void setRadius(double r) {
		super.setDimension1(r);
		super.setDimension2(r);
	}
	
	public double getArea() {
		return Math.PI * super.getDimension1() * super.getDimension1();
	}
	
  public void resize(double ratio) {
    /**
      TODO: Implement an interface Sizable, which has method ¡°void resize(double ratio)¡±.
            (The area of the shape will be change ratio times)  

      HINT: 
      If the shape is Rectangle -> width = width * ratio;
      If the shape is Circle or Square-> radius/side = radius/side * sqrt(ratio); 
      **/
    setRadius(getRadius() * Math.sqrt(ratio));
  }
}
