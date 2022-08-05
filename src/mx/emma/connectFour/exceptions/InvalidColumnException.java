package mx.emma.connectFour.exceptions;

public class InvalidColumnException extends ConnectFourException{
	public InvalidColumnException() {
	}

	public InvalidColumnException(String message) {
		super(message);
	}
}
