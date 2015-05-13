package jp.canetrash.ingress.mail;


public class ParserFactory {

	public static Parser getParser() {
		return new SimpleParser();
	}
}
