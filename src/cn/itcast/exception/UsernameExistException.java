package cn.itcast.exception;

@SuppressWarnings("serial")
public class UsernameExistException extends Exception {

	public UsernameExistException() {
	}

	public UsernameExistException(String message) {
		super(message);
	}

	public UsernameExistException(Throwable cause) {
		super(cause);
	}

	public UsernameExistException(String message, Throwable cause) {
		super(message, cause);
	}

}
