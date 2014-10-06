package jp.canetrash.ingress.mail;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.FileInputStream;

import javax.mail.internet.MimeMessage;

import org.junit.Test;

public class SimpleParserTest {

	private SimpleParser target = new SimpleParser();

	@Test
	public void simpleTest() throws Exception {
		MimeMessage msg = new MimeMessage(null, new FileInputStream(
				"src/test/resources/damage-report1.eml"));

		DamageReportMail actual = target.parse(msg);
		assertThat(actual.getFrom(), is("Niantic Project Operations"));
		assertThat(actual.getTo(), is("atomosphere"));
		assertThat(actual.getSubject(),
				is("Ingress Damage Report: Entities attacked by matahaari"));
		assertThat(actual.getPortalName(), is("恵比寿駅前噴水"));

	}

}
