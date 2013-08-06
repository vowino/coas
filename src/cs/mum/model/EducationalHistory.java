package cs.mum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EducationalHistory extends Section {
	private long id;
	private char hSchoolStatus;
	private int hDAYear;
	private String hDAField;
	private String notOnListDAField;
	private String notOnListDADegree;
	private Country countryDegreeGranted;
	private String notOnListCountryDegreeGranted;
	private String gradingScaleUsed;
	private double degreeGPA;
	private int totalYear;
	private int totalMonth;
	
	
	public EducationalHistory() {
		
	}
	public EducationalHistory(char hSchoolStatus, int hDAYear, String hDAField,
			String notOnListDAField, String notOnListDADegree,
			Country countryDegreeGranted, String notOnListCountryDegreeGranted,
			String gradingScaleUsed, double degreeGPA, int totalYear,
			int totalMonth) {
		this.hSchoolStatus = hSchoolStatus;
		this.hDAYear = hDAYear;
		this.hDAField = hDAField;
		this.notOnListDAField = notOnListDAField;
		this.notOnListDADegree = notOnListDADegree;
		this.countryDegreeGranted = countryDegreeGranted;
		this.notOnListCountryDegreeGranted = notOnListCountryDegreeGranted;
		this.gradingScaleUsed = gradingScaleUsed;
		this.degreeGPA = degreeGPA;
		this.totalYear = totalYear;
		this.totalMonth = totalMonth;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public char gethSchoolStatus() {
		return hSchoolStatus;
	}
	public void sethSchoolStatus(char hSchoolStatus) {
		this.hSchoolStatus = hSchoolStatus;
	}
	public int gethDAYear() {
		return hDAYear;
	}
	public void sethDAYear(int hDAYear) {
		this.hDAYear = hDAYear;
	}
	public String gethDAField() {
		return hDAField;
	}
	public void sethDAField(String hDAField) {
		this.hDAField = hDAField;
	}
	public String getNotOnListDAField() {
		return notOnListDAField;
	}
	public void setNotOnListDAField(String notOnListDAField) {
		this.notOnListDAField = notOnListDAField;
	}
	public String getNotOnListDADegree() {
		return notOnListDADegree;
	}
	public void setNotOnListDADegree(String notOnListDADegree) {
		this.notOnListDADegree = notOnListDADegree;
	}
	public Country getCountryDegreeGranted() {
		return countryDegreeGranted;
	}
	public void setCountryDegreeGranted(Country countryDegreeGranted) {
		this.countryDegreeGranted = countryDegreeGranted;
	}
	public String getNotOnListCountryDegreeGranted() {
		return notOnListCountryDegreeGranted;
	}
	public void setNotOnListCountryDegreeGranted(
			String notOnListCountryDegreeGranted) {
		this.notOnListCountryDegreeGranted = notOnListCountryDegreeGranted;
	}
	public String getGradingScaleUsed() {
		return gradingScaleUsed;
	}
	public void setGradingScaleUsed(String gradingScaleUsed) {
		this.gradingScaleUsed = gradingScaleUsed;
	}
	public double getDegreeGPA() {
		return degreeGPA;
	}
	public void setDegreeGPA(double degreeGPA) {
		this.degreeGPA = degreeGPA;
	}
	public int getTotalYear() {
		return totalYear;
	}
	public void setTotalYear(int totalYear) {
		this.totalYear = totalYear;
	}
	public int getTotalMonth() {
		return totalMonth;
	}
	public void setTotalMonth(int totalMonth) {
		this.totalMonth = totalMonth;
	}
	
	
	

}
