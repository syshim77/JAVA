package Exercise;
import java.util.*;

public class main {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    Rectangle rectangle = new Rectangle();

    int choice = getMenuChoice();
    while (choice != 3) {
      try {
        switch (choice) {
        case 1:
          System.out.print("Enter height: ");
          rectangle.setHeight(input.nextDouble());
          break;
        case 2:
          System.out.print("Enter height: ");
          rectangle.setWidth(input.nextDouble());
          break;
        }

        System.out.println(rectangle.toString());
      } catch (IllegalArgumentException e) {
        System.out.println("height and width must be 0.0 - 20.0\n");
      }

      choice = getMenuChoice();
    }
  }

  private static int getMenuChoice() {
    Scanner input = new Scanner(System.in);

    System.out.println("1. Set Height");
    System.out.println("2. Set Width");
    System.out.println("3. Exit");
    System.out.print("Choice : ");

    return input.nextInt();
  }
}