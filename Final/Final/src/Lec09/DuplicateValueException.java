package Lec09;
public class DuplicateValueException extends Exception {
	// no-argument constructor specifies default error message
	public DuplicateValueException() {
		super("Integer can not be a duplicate.");
	}

	// constructor to allow customized error message
	public DuplicateValueException(String message) {
		super(message);
	}
}