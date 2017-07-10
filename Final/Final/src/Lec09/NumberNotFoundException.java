package Lec09;
public class NumberNotFoundException extends Exception {
	// no-argument constructor specifies default error message
	public NumberNotFoundException() {
		super("Number not found in array");
	}

	// constructor to allow customized error message
	public NumberNotFoundException(String message) {
		super(message);
	}
}
