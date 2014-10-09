package jp.canetrash.ingress.mail;

/**
 * @author tfunato
 * 
 */
public class IngressMailParseException extends RuntimeException {

	private static final long serialVersionUID = -7116836187305033631L;

	public IngressMailParseException() {
		super();
	}

	public IngressMailParseException(String message) {
		super(message);
	}

	public IngressMailParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public IngressMailParseException(Throwable cause) {
		super(cause);
	}
}
