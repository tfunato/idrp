package jp.canetrash.ingress.mail;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;

public abstract class AbstractParser implements Parser {

	protected InternetAddress getTo(Message msg) throws Exception {
		Address[] to = msg.getRecipients(Message.RecipientType.TO);
		if (to != null && to.length != 0) {
			return (InternetAddress) to[0]; // use first
		}
		return null;
	}

	protected InternetAddress getFrom(Message msg) throws Exception {
		Address[] from = msg.getFrom();
		if (from != null && from.length != 0) {
			return (InternetAddress) from[0]; // use first
		}
		return null;
	}

	protected String getSubject(Message msg) throws Exception {
		return msg.getSubject();
	}

}
