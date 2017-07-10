package solution;

public class Square extends Rectangle {
	private static String CLASS_NAME = "Square";
	public Square(String name, double side) {
		// this will call the constructor of Rectangle
		super(name, side, side);
	}
	
	@Override
	public String getClassName(){
		return CLASS_NAME; 
	}
	
	public double getSide() {
		return super.getWidth();
	}
	
	public void setSide(double side) {
		super.setSize(side, side);		
	}
	
	@Override
  public void resize(double ratio) {
    /**
      TODO: Implement an interface Sizable, which has method ¡°void resize(double ratio)¡±.
            (The area of the shape will be change ratio times)  

      HINT: 
      If the shape is Rectangle -> width = width * ratio;
      If the shape is Circle or Square-> radius/side = radius/side * sqrt(ratio); 
      **/
	  setSide(getSide() * Math.sqrt(ratio));
	}
}