package jp.canetrash.ingress.mail;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SimpleParser extends AbstractParser {

	@Override
	public DamageReportMail parse(Message msg) throws Exception {
		DamageReportMail mail = new DamageReportMail();
		InternetAddress from = getFrom(msg);
		if (from != null) {
			mail.setFrom(from.getPersonal());
		}
		InternetAddress to = getTo(msg);
		if (to != null) {
			mail.setTo(to.getPersonal());
		}
		mail.setSubject(getSubject(msg));

		Object content = msg.getContent();
		if (content instanceof Multipart) {
			final Multipart multiPart = (Multipart) content;
			for (int i = 0; i < multiPart.getCount(); i++) {
				final Part part = multiPart.getBodyPart(i);
				final String contentType = part.getContentType();
				if (contentType.indexOf("text/html") != -1) {
					Document doc = Jsoup.parse(part.getContent().toString());
					// portal name
					Elements element = doc
							.select("body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(3) > td > div:nth-child(1)");
					mail.setPortalName(element.text());

				}
			}
		}
		return mail;
	}

}
