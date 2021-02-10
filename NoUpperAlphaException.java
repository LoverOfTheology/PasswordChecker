package application;

public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		super("Password doesn’t contain an uppercase alpha character");
	}
}
