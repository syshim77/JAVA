package Exercise1;
import java.util.Scanner;

public class pr1_FirstProgram {
	public static void main(String[] args){
		System.out.printf("Input your name: ");
		Scanner input = new Scanner(System.in);
		String message;
		message = input.nextLine();
		System.out.printf("Hello " + message + ".");
		input.close();
	}
}