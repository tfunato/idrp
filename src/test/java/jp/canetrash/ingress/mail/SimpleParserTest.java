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
		assertThat(actual.getAgentName(), is("atomosphere"));
		assertThat(actual.getFaction(), is("Resistance"));
		assertThat(actual.getAgentLevel(), is("L9"));
		assertThat(
				actual.getPortalAddress(),
				is("Komazawa Dori, １丁目 Ebisuminami, Shibuya, Tokyo 150-0013, Japan"));
		assertThat(
				actual.getPortalIntelUrl(),
				is("https://www.ingress.com/intel?ll=35.647189,139.709069&pll=35.647189,139.709069&z=19"));
		assertThat(
				actual.getPortalImageUrl(),
				is("http://lh6.ggpht.com/FUZkUTk6re3dn9QKX3odoai2rb6HEbVt3mV5uZKON8DkZEA0L7BuVXLrqDC7smv9mcY7nsrwCl9BXD61B-k"));
		assertThat(
				actual.getPortalStatusImageUrl(),
				is("http://maps.googleapis.com/maps/api/staticmap?center=35.647189,139.709169&zoom=19&size=700x160&sensor=false&style=visibility:on%7Csaturation:-50%7Cinvert_lightness:true%7Chue:0x131c1c&style=feature:water%7Cvisibility:on%7Chue:0x005eff%7Cinvert_lightness:true&style=feature:poi%7Cvisibility:off&style=feature:transit%7Cvisibility:off&markers=icon:http://commondatastorage.googleapis.com/ingress.com/img/map_icons/marker_images/neutral_icon.png%7Cshadow:false%7C35.647189,139.709069"));
		assertThat(actual.getEnemyAgentName(), is("matahaari"));
		assertThat(actual.getCurrentPortalLevel(), is("1"));
		assertThat(actual.getCurrentPortalHealth(), is("0%"));
		assertThat(actual.getCurrentPortalOwner(), is("[uncaptured]"));
	}
}
