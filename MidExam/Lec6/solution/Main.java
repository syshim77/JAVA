package solution;

public class Main
{
  public static void main(String[] args)
  {
    // Create an 2D Shape objects in array
    TwoDimensionalShape[] myShapes = new TwoDimensionalShape[5];
    Sizable a = new Sizable() {
      
      @Override
      public void resize(double ratio) {
        // TODO Auto-generated method stub
        
      }
    };
    
    Sizable l = (double ratio) -> System.out.println();
    Sizable k = new Sizable() {
      public void resize(double ratio) {
           System.out.println();
      }
    };
    
    myShapes[0] = new Circle("CirObject1", 3.0);
    myShapes[1] = new Rectangle("RecObject1", 3.0, 4.0);
    myShapes[2] = new Square("SquObject1", 6.0);
    myShapes[3] = new Rectangle("RecObject2", 4.0, 5.0);
    myShapes[4] = new Circle("CirObject2", 5.0);

    // Print objects
    System.out.println("Five shapes have been created:");
    for (int i = 0; i < myShapes.length; i++)
    {
      System.out.println((i + 1) + ": " + myShapes[i]);
      System.out.println(" Area = " + String.format("%.2f", myShapes[i].getArea()));
    }
    System.out.println();
    
    // Print all shapes again
    System.out.println("The following are resized:");
    for (int i = 0; i < myShapes.length; i++)
    {
      myShapes[i].resize(2);
      System.out.println((i + 1) + ": " + myShapes[i]);
      System.out.println(" Area = " + String.format("%.2f", myShapes[i].getArea()));
    }
    System.out.println();

    System.out.println(myShapes[2].getName() + " compared to " + myShapes[3].getName() + " gives: " + toWordCompare(myShapes[2].compareTo(myShapes[3])));
    System.out.println(myShapes[3].getName() + " compared to " + myShapes[2].getName() + " gives: " + toWordCompare(myShapes[3].compareTo(myShapes[2])));
    
  }
  
  public static String toWordCompare(int val)
  {
    /**
    TODO: Implement an interface Sizable, which has method ¡°void resize(double ratio)¡±.
          (The area of the shape will be change ratio times)  
    Implement toWordCompare method to compare the area of any two 2D objects (such as: Circle, Rectangle, Square).
    It return 0 if equal, -1 if smaller, +1 if larger.Example: cir1.compareTo(rec1), sq1.compareTo(rec1) ...
    **/
    if (val > 0)
    {
      return "Larger";
    }
    else if (val < 0)
    {
      return "Smaller";
    }
    return "Equal";
  }

}
