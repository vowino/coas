package cs.mum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FinalSection extends Section {
	private long id;
	private String programType;
	private String targetEntry;
	private String hearAboutUs;
	private String notOnhearAboutUs;
	private String agentCode;
	private String signature;
	
	
	public FinalSection() {
		
	}
	public FinalSection(String programType, String targetEntry,
			String hearAboutUs, String notOnhearAboutUs, String agentCode,
			String signature) {
		this.programType = programType;
		this.targetEntry = targetEntry;
		this.hearAboutUs = hearAboutUs;
		this.notOnhearAboutUs = notOnhearAboutUs;
		this.agentCode = agentCode;
		this.signature = signature;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProgramType() {
		return programType;
	}
	public void setProgramType(String programType) {
		this.programType = programType;
	}
	public String getTargetEntry() {
		return targetEntry;
	}
	public void setTargetEntry(String targetEntry) {
		this.targetEntry = targetEntry;
	}
	public String getHearAboutUs() {
		return hearAboutUs;
	}
	public void setHearAboutUs(String hearAboutUs) {
		this.hearAboutUs = hearAboutUs;
	}
	public String getNotOnhearAboutUs() {
		return notOnhearAboutUs;
	}
	public void setNotOnhearAboutUs(String notOnhearAboutUs) {
		this.notOnhearAboutUs = notOnhearAboutUs;
	}
	public String getAgentCode() {
		return agentCode;
	}
	public void setAgentCode(String agentCode) {
		this.agentCode = agentCode;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	

}
