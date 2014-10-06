package jp.canetrash.ingress.mail;

import javax.mail.Message;

public class ParserFactory {

	public static Parser getParser(Message msg) {
		return new SimpleParser();
	}
}
