package cs.mum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User {
	private long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailAddress;
	private String status;
	private ApplicantLogin userLogin;
	
	public User() {
		
	}
	
	
	public User(String firstName, String middleName, String lastName,
			String emailAddress, String status, ApplicantLogin userLogin) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.status = status;
		this.userLogin = userLogin;
	}


	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ApplicantLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(ApplicantLogin userLogin) {
		this.userLogin = userLogin;
	}
	
	

}
