package jp.canetrash.ingress.mail;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileInputStream;

import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class SimpleParserTest {

	private SimpleParser target = new SimpleParser();

	@Test
	public void pattern1Test() throws Exception {
		MimeMessage msg = new MimeMessage(null, new FileInputStream(
				"src/test/resources/damage-report1.eml"));
		DamageReportMail actual = target.parse(msg);
		assertThat(actual.getMessageId(), is("<089e013a038648bdf9050560060c@google.com>"));
		assertThat(actual.getTo(), is("atomosphere"));
		assertThat(actual.getFrom(), is("Niantic Project Operations"));
		assertThat(actual.getAgentName(), is("atomosphere"));
		assertThat(actual.getOppositeAgentName(), is("johnfkenjiro"));
		assertThat(actual.getDate().getTime(), is(1413284863000L));
		assertThat(actual.getSubject(), is("Ingress Damage Report: Entities attacked by johnfkenjiro"));
		assertThat(actual.getPortals().size(), is(1));
		assertThat(actual.getPortals().get(0).getPortalName(), is("湊橋観光案内板"));
		assertThat(actual.getPortals().get(0).getLongitude(), is("139.783277"));
		assertThat(actual.getPortals().get(0).getLatitude(), is("35.678996"));
		assertThat(actual.getPortals().get(0).getPortalIntelUrl(), is("https://www.ingress.com/intel?ll=35.678996,139.783277&pll=35.678996,139.783277&z=19"));
	}

	@Test
	public void pattern2Test() throws Exception {
		MimeMessage msg = new MimeMessage(null, new FileInputStream(
				"src/test/resources/damage-report2.eml"));
		DamageReportMail actual = target.parse(msg);
		assertThat(actual.getMessageId(), is("<001a1134aeac8919ad0514fc5ff2@google.com>"));
		assertThat(actual.getTo(), is("atomosphere"));
		assertThat(actual.getFrom(), is("Niantic Project Operations"));
		assertThat(actual.getAgentName(), is("atomosphere"));
		assertThat(actual.getOppositeAgentName(), is("testtest"));
		assertThat(actual.getDate().getTime(), is(1430449050000L));
		assertThat(actual.getSubject(), is("Ingress Damage Report: Entities attacked by testtest"));
		assertThat(actual.getPortals().size(), is(2));
		assertThat(actual.getPortals().get(0).getPortalName(), is("浅草郵便局 Aasakusa Post Office"));
		assertThat(actual.getPortals().get(0).getLongitude(), is("139.790704"));
		assertThat(actual.getPortals().get(0).getLatitude(), is("35.709946"));
		assertThat(actual.getPortals().get(0).getPortalIntelUrl(), is("https://www.ingress.com/intel?ll=35.709946,139.790704&pll=35.709946,139.790704&z=19"));

		assertThat(actual.getPortals().get(1).getPortalName(), is("願龍寺"));
		assertThat(actual.getPortals().get(1).getLongitude(), is("139.790373"));
		assertThat(actual.getPortals().get(1).getLatitude(), is("35.710209"));
		assertThat(actual.getPortals().get(1).getPortalIntelUrl(), is("https://www.ingress.com/intel?ll=35.710209,139.790373&pll=35.710209,139.790373&z=19"));
	}
}
