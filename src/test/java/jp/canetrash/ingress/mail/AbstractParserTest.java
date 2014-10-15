package jp.canetrash.ingress.mail;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.mail.Message;

import org.junit.Test;

public class AbstractParserTest {

	private AbstractParser target = new AbstractParser() {
		@Override
		public DamageReportMail parse(Message msg) {
			return null;
		}
	};

	@Test
	public void test() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		cal.set(2014, 9, 10, 3, 50, 0);
		Date actual = target.getAlertDateFromDamageReport(cal.getTime(),
				"hogehoge 03:47 abebe");
		System.out.println(actual);
		Calendar targetCal = Calendar.getInstance();
		targetCal.setTimeInMillis(actual.getTime());
		assertThat(targetCal.get(Calendar.YEAR), is(2014));
		assertThat(targetCal.get(Calendar.MONTH), is(9));
		assertThat(targetCal.get(Calendar.DAY_OF_MONTH), is(10));
		assertThat(targetCal.get(Calendar.HOUR_OF_DAY), is(12));
		assertThat(targetCal.get(Calendar.MINUTE), is(47));
	}

	@Test
	public void testDayOver() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.setTimeZone(TimeZone.getTimeZone("GMT"));
		cal.set(2014, 9, 11, 15, 5, 0);
		Date actual = target.getAlertDateFromDamageReport(cal.getTime(),
				"hogehoge 14:59 abebe");
		Calendar targetCal = Calendar.getInstance();
		targetCal.clear();
		targetCal.setTimeZone(TimeZone.getTimeZone("GMT"));
		targetCal.setTimeInMillis(actual.getTime());
		assertThat(targetCal.get(Calendar.YEAR), is(2014));
		assertThat(targetCal.get(Calendar.MONTH), is(9));
		assertThat(targetCal.get(Calendar.DAY_OF_MONTH), is(11));
		assertThat(targetCal.get(Calendar.HOUR_OF_DAY), is(14));
		assertThat(targetCal.get(Calendar.MINUTE), is(59));
	}
}
