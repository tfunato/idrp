package jp.canetrash.ingress.mail;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

public abstract class AbstractParser implements Parser {

	private static final Pattern TIME_PATTERN = Pattern
			.compile("(\\d\\d:\\d\\d)");

	protected InternetAddress getTo(Message msg) {
		Address[] to;
		try {
			to = msg.getRecipients(Message.RecipientType.TO);
		} catch (MessagingException e) {
			throw new IngressMailParseException("to parse error", e);
		}
		if (to != null && to.length != 0) {
			return (InternetAddress) to[0]; // use first
		}
		return null;
	}

	protected InternetAddress getFrom(Message msg) {
		Address[] from;
		try {
			from = msg.getFrom();
		} catch (MessagingException e) {
			throw new IngressMailParseException("from parse error", e);
		}
		if (from != null && from.length != 0) {
			return (InternetAddress) from[0]; // use first
		}
		return null;
	}

	protected String getSubject(Message msg) {
		try {
			return msg.getSubject();
		} catch (MessagingException e) {
			throw new IngressMailParseException("subject parse error", e);
		}
	}

	protected Date getAlertDateFromDamageReport(String damageReport) {
		Matcher matcher = TIME_PATTERN.matcher(damageReport);
		if (matcher.find()) {
			// LocalはGMT
			String time = matcher.group();
			// XXX 時間しか無いので単純にCalendarにセットするだけでは、日付またぎに対応できないため工夫が必要
		} else {
			throw new IngressMailParseException("cant get alert date.["
					+ damageReport + "]");
		}
		return null;
	}

}
