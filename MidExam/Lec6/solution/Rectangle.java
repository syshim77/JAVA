package solution;

public class Rectangle extends TwoDimensionalShape {
  private static final String CLASS_NAME = "Rectangle";
  
  public Rectangle()
  {
    super();
  }
	public Rectangle(String name, double width, double height) {
		// store width in field demension1, height in field demension2
		super(name, width, height);
	}

	@Override
	public String getClassName(){
		return CLASS_NAME; 
	}
	
	public double getWidth() {
		return super.getDimension1();
	}
	
	public void setWidth(double width) {
    super.setDimension1(width);
  } 

	public double getHeight() {
		return super.getDimension2();
	}
	
	 public void setHeight(double height) {
	    super.setDimension2(height);
	  }

	public void setSize(double width, double height){
		super.setDimension1(width);
		super.setDimension2(height);
	}
	
	public double getArea() {
		return super.getDimension1() * super.getDimension2();
	}

  public void resize(double ratio) {
    /**
      TODO: Implement an interface Sizable, which has method ��void resize(double ratio)��.
            (The area of the shape will be change ratio times)  

      HINT: 
      If the shape is Rectangle -> width = width * ratio;
      If the shape is Circle or Square-> radius/side = radius/side * sqrt(ratio); 
      **/
    setWidth(getWidth() * ratio);
  }
  
  @Override
  public String toString()
  {
    return String.format("%s is a [%s], and is a [%s]", super.getName(), getClassName(), super.getClassName());
  }
}
