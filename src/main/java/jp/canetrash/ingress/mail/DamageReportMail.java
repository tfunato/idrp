package jp.canetrash.ingress.mail;

import java.util.Date;

/**
 * Ingress damage report mail
 * 
 * @author tfunato
 * 
 */
public class DamageReportMail {

	private String from;

	private String to;

	private String subject;

	private String agentName;

	private String faction;

	private String agentLevel;

	private String portalName;

	private String portalAddress;

	private String portalIntelUrl;

	private String portalImageUrl;

	private String portalStatusImageUrl;

	private String enemyAgentName;

	private String currentPortalLevel;

	private String currentPortalHealth;

	private String currentPortalOwner;

	private Date alertDate;

	/** 経度 */
	private String portalLongitude;

	/** 緯度 */
	private String portalLatitude;

	private String damageReport;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getAgentLevel() {
		return agentLevel;
	}

	public void setAgentLevel(String agentLevel) {
		this.agentLevel = agentLevel;
	}

	public String getPortalName() {
		return portalName;
	}

	public void setPortalName(String portalName) {
		this.portalName = portalName;
	}

	public String getPortalAddress() {
		return portalAddress;
	}

	public void setPortalAddress(String portalAddress) {
		this.portalAddress = portalAddress;
	}

	public String getPortalIntelUrl() {
		return portalIntelUrl;
	}

	public void setPortalIntelUrl(String portalIntelUrl) {
		this.portalIntelUrl = portalIntelUrl;
	}

	public String getPortalImageUrl() {
		return portalImageUrl;
	}

	public void setPortalImageUrl(String portalImageUrl) {
		this.portalImageUrl = portalImageUrl;
	}

	public String getPortalStatusImageUrl() {
		return portalStatusImageUrl;
	}

	public void setPortalStatusImageUrl(String portalStatusImageUrl) {
		this.portalStatusImageUrl = portalStatusImageUrl;
	}

	public String getEnemyAgentName() {
		return enemyAgentName;
	}

	public void setEnemyAgentName(String enemyAgentName) {
		this.enemyAgentName = enemyAgentName;
	}

	public String getCurrentPortalLevel() {
		return currentPortalLevel;
	}

	public void setCurrentPortalLevel(String currentPortalLevel) {
		this.currentPortalLevel = currentPortalLevel;
	}

	public String getCurrentPortalHealth() {
		return currentPortalHealth;
	}

	public void setCurrentPortalHealth(String currentPortalHealth) {
		this.currentPortalHealth = currentPortalHealth;
	}

	public String getCurrentPortalOwner() {
		return currentPortalOwner;
	}

	public void setCurrentPortalOwner(String currentPortalOwner) {
		this.currentPortalOwner = currentPortalOwner;
	}

	public Date getAlertDate() {
		return alertDate;
	}

	public void setAlertDate(Date alertDate) {
		this.alertDate = alertDate;
	}

	public String getPortalLongitude() {
		return portalLongitude;
	}

	public void setPortalLongitude(String portalLongitude) {
		this.portalLongitude = portalLongitude;
	}

	public String getPortalLatitude() {
		return portalLatitude;
	}

	public void setPortalLatitude(String portalLatitude) {
		this.portalLatitude = portalLatitude;
	}

	public String getDamageReport() {
		return damageReport;
	}

	public void setDamageReport(String damageReport) {
		this.damageReport = damageReport;
	}
}
