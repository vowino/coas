package cs.mum.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonalInformation extends Section {
	private long id;
	private String sex;
	private String maritalStatus;
	private Country countryOfCitizenship;
	private Country counryOfBirth;
	private String notOnListOfcountryOfCitizenship;
	private String notOnListOfcountryOfBirth;
	private Date DateOfBirth;
	private String skypeId;
	private String phoneNumber;
	private String cityLivingNow;
	private Country countrylivingNow;
	private String notOnListOfCountryLivingNow;
	
	
	public PersonalInformation() {
	
	}
	public PersonalInformation(String sex, String maritalStatus,
			Country countryOfCitizenship, Country counryOfBirth,
			String notOnListOfcountryOfCitizenship,
			String notOnListOfcountryOfBirth, Date dateOfBirth, String skypeId,
			String phoneNumber, String cityLivingNow, Country countrylivingNow,
			String notOnListOfCountryLivingNow) {
		this.sex = sex;
		this.maritalStatus = maritalStatus;
		this.countryOfCitizenship = countryOfCitizenship;
		this.counryOfBirth = counryOfBirth;
		this.notOnListOfcountryOfCitizenship = notOnListOfcountryOfCitizenship;
		this.notOnListOfcountryOfBirth = notOnListOfcountryOfBirth;
		DateOfBirth = dateOfBirth;
		this.skypeId = skypeId;
		this.phoneNumber = phoneNumber;
		this.cityLivingNow = cityLivingNow;
		this.countrylivingNow = countrylivingNow;
		this.notOnListOfCountryLivingNow = notOnListOfCountryLivingNow;
	}
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Country getCountryOfCitizenship() {
		return countryOfCitizenship;
	}
	public void setCountryOfCitizenship(Country countryOfCitizenship) {
		this.countryOfCitizenship = countryOfCitizenship;
	}
	public Country getCounryOfBirth() {
		return counryOfBirth;
	}
	public void setCounryOfBirth(Country counryOfBirth) {
		this.counryOfBirth = counryOfBirth;
	}
	public String getNotOnListOfcountryOfCitizenship() {
		return notOnListOfcountryOfCitizenship;
	}
	public void setNotOnListOfcountryOfCitizenship(
			String notOnListOfcountryOfCitizenship) {
		this.notOnListOfcountryOfCitizenship = notOnListOfcountryOfCitizenship;
	}
	public String getNotOnListOfcountryOfBirth() {
		return notOnListOfcountryOfBirth;
	}
	public void setNotOnListOfcountryOfBirth(String notOnListOfcountryOfBirth) {
		this.notOnListOfcountryOfBirth = notOnListOfcountryOfBirth;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getSkypeId() {
		return skypeId;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCityLivingNow() {
		return cityLivingNow;
	}
	public void setCityLivingNow(String cityLivingNow) {
		this.cityLivingNow = cityLivingNow;
	}
	public Country getCountrylivingNow() {
		return countrylivingNow;
	}
	public void setCountrylivingNow(Country countrylivingNow) {
		this.countrylivingNow = countrylivingNow;
	}
	public String getNotOnListOfCountryLivingNow() {
		return notOnListOfCountryLivingNow;
	}
	public void setNotOnListOfCountryLivingNow(String notOnListOfCountryLivingNow) {
		this.notOnListOfCountryLivingNow = notOnListOfCountryLivingNow;
	}
	
	
	
	

}
