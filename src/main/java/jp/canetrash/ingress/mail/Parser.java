package jp.canetrash.ingress.mail;

import javax.mail.Message;


/**
 * Ingress Damage Report Parser
 * 
 * @author tfunato
 * 
 */
public interface Parser {
	DamageReportMail parse(Message msg) throws Exception;
}
