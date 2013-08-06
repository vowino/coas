package cs.mum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SelfStudy extends Section {
	private long id;
	private ProgrammingLanguage programmingLanguage;
	private String notOnListProgrammingLanguage;
	private String resource;
	private int weeks;
	private int years;
	private int hoursPerWeek;
	private String projectDescription;
	
	
	public SelfStudy() {
		
	}
	public SelfStudy(ProgrammingLanguage programmingLanguage,
			String notOnListProgrammingLanguage, String resource, int weeks,
			int years, int hoursPerWeek, String projectDescription) {
		this.programmingLanguage = programmingLanguage;
		this.notOnListProgrammingLanguage = notOnListProgrammingLanguage;
		this.resource = resource;
		this.weeks = weeks;
		this.years = years;
		this.hoursPerWeek = hoursPerWeek;
		this.projectDescription = projectDescription;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ProgrammingLanguage getProgrammingLanguage() {
		return programmingLanguage;
	}
	public void setProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}
	public String getNotOnListProgrammingLanguage() {
		return notOnListProgrammingLanguage;
	}
	public void setNotOnListProgrammingLanguage(String notOnListProgrammingLanguage) {
		this.notOnListProgrammingLanguage = notOnListProgrammingLanguage;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public int getWeeks() {
		return weeks;
	}
	public void setWeeks(int weeks) {
		this.weeks = weeks;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getHoursPerWeek() {
		return hoursPerWeek;
	}
	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}
	public String getProjectDescription() {
		return projectDescription;
	}
	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	

}
