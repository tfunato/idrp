package jp.canetrash.ingress.mail;

import java.net.URL;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.InternetAddress;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SimpleParser extends AbstractParser {

	@Override
	public DamageReportMail parse(Message msg) {
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

		try {
			mail.setSentDate(msg.getSentDate());
			Object content = msg.getContent();
			if (content instanceof Multipart) {
				final Multipart multiPart = (Multipart) content;
				for (int i = 0; i < multiPart.getCount(); i++) {
					final Part part = multiPart.getBodyPart(i);
					final String contentType = part.getContentType();
					if (contentType.indexOf("text/html") != -1) {
						Document doc = Jsoup
								.parse(part.getContent().toString());
						// agent name
						Elements element = doc.select(AGENT_NAME_CSSSELECTOR);
						mail.setAgentName(element.text());
						// faction
						element = doc.select(FACTION_CSSSELECTOR);
						mail.setFaction(element.text());
						// agent level
						element = doc.select(AGENT_LEVEL_CSSSELECTOR);
						mail.setAgentLevel(element.text());
						// portal name
						element = doc.select(PORTAL_NAME_CSSSELECTOR);
						mail.setPortalName(element.text());
						// portal address
						element = doc.select(PORTAL_ADDRESS_CSSSELECTOR);
						mail.setPortalAddress(element.text());
						// portal url
						String intelUrl = element.attr("href");
						mail.setPortalIntelUrl(intelUrl);
						// portal lng lag
						URL url = new URL(intelUrl);
						String query = url.getQuery();
						String[] params = query.split("&");
						for (String param : params) {
							if (param.indexOf("pll") != -1) {
								String[] latlng = param.split("=")[1]
										.split(",");
								// longitude
								mail.setPortalLatitude(latlng[0]);
								// latitude
								mail.setPortalLongitude(latlng[1]);
								break;
							}
						}

						// portal image url
						element = doc.select(PORTAL_IMAGE_URL_CSSSELECTOR);
						mail.setPortalImageUrl(element.attr("src"));
						// portal status image url
						element = doc
								.select(PORTAL_STATUS_IMAGE_URL_CSSSELECTOR);
						mail.setPortalStatusImageUrl(element.attr("src"));
						// enemy agent name
						element = doc.select(ENEMY_AGENT_NAME_CSSSELECTOR);
						mail.setEnemyAgentName(element.text());
						element = doc.select(CURRENT_PORTAL_STATUS_CSSSELECTOR);
						String status = element.text();
						// status format
						// STATUS: Level 1 Health: 0% Owner: [uncaptured]
						String[] strArry = status.split(" ");
						// current portal level
						mail.setCurrentPortalLevel(strArry[2]);
						// current portal health
						mail.setCurrentPortalHealth(strArry[4]);
						// current portal owner
						mail.setCurrentPortalOwner(strArry[6]);
						// damege report
						element = doc.select(DAMAGE_REPORT_CSSSELECTOR);
						mail.setDamageReport(element.text());
						// alert date
						mail.setAlertDate(mail.getSentDate());

						// html parse end
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new IngressMailParseException(e);
		}
		return mail;
	}

	private static final String PORTAL_NAME_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(3) > td > div:nth-child(1)";
	private static final String AGENT_NAME_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td > span:nth-child(2)";
	private static final String FACTION_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td > span:nth-child(5)";
	private static final String AGENT_LEVEL_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(1) > td > span:nth-child(8)";
	private static final String PORTAL_ADDRESS_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(3) > td > div:nth-child(2) > a";
	private static final String PORTAL_IMAGE_URL_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(4) > td > div > div:nth-child(1) > img";
	private static final String PORTAL_STATUS_IMAGE_URL_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(4) > td > div > div:nth-child(2) > img";
	private static final String ENEMY_AGENT_NAME_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(5) > td > table > tbody > tr > td:nth-child(1) > div > span";
	private static final String CURRENT_PORTAL_STATUS_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(5) > td > table > tbody > tr > td:nth-child(2) > div";
	private static final String DAMAGE_REPORT_CSSSELECTOR = "body > div > table > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(5) > td > table > tbody > tr > td:nth-child(1) > div";

}
