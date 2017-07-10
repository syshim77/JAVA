package Exercise2;
import java.util.Scanner;

public class pr2_Numbers {
	public static void main(String[] args) {
		int message1, message2, message3;
		int smallest, largest;
		System.out.printf("Enter first integer :");
		Scanner input = new Scanner(System.in);
		message1 = input.nextInt();
		System.out.printf("Enter second integer :");
		message2 = input.nextInt();
		System.out.printf("Enter third integer :");
		message3 = input.nextInt();
		
		if(message1 >= message2)
			if(message1 >= message3){
				largest = message1;
				if(message2 >= message3)
					smallest = message3;
				else
					smallest = message2;
			}				
			else{
				largest = message3;
				smallest = message2;
			}			
		else
			if(message2 >= message3){
				largest = message2;
				if(message1 >= message3)
					smallest = message3;
				else
					smallest = message1;
			}				
			else{
				largest = message3;
				smallest = message1;
			}
		
		input.close();
				
		System.out.print("For the numbers " + message1 + ", " + message2 + ", and " +message3 +"\n");
		System.out.print("Largest is " + largest + "\n");
		System.out.print("Smallest is " + smallest + "\n");
		System.out.print("Sum is " + (message1 + message2 + message3) + "\n");
		System.out.print("Product is " + (message1 * message2 * message3) + "\n");
		System.out.print("Average is " + (double)(message1 + message2 + message3)/3+ "\n");
	}
}
