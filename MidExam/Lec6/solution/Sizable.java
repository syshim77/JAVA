package solution;

public interface Sizable
{
  /**
  # TODO: Implement an interface Sizable, which has method ¡°void resize(double ratio)¡±.
          (The area of the shape will be change ratio times)  

    HINT: 
    If the shape is Rectangle -> width = width * ratio;
    If the shape is Circle or Square -> radius/side = radius/side * sqrt(ratio);
  **/
  void resize(double ratio);
}  