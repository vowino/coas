package cs.mum.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cs.mum.model.Applicant;
import cs.mum.model.ApplicantLogin;
import cs.mum.services.ApplicantLoginService;
@Service
public class ApplicantValidator implements Validator {
	@Autowired
	private ApplicantLoginService applicantLoginService;

	public void setApplicantLoginService(ApplicantLoginService applicantLoginService) {
		this.applicantLoginService = applicantLoginService;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Applicant.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Applicant applicant = (Applicant)target;
		List<ApplicantLogin> list = applicantLoginService.
				getApplicantByEmailAddress(applicant.getEmailAddress());
		
		if(applicant.getFirstName() == "" || applicant.getLastName() == "" 
				|| applicant.getEmailAddress() == "" || applicant.getLogin().getPassword() == ""
				|| !(applicant.getLogin().getPassword().equals(applicant.getLogin().getConfirmPassword())) 
				|| list.size()>0) {
			
			if(applicant.getFirstName() == "") {
				errors.reject("firstName", "First name can not be blank!");
			}
			
			if(applicant.getLastName() == "") {
				errors.reject("lastName", "Last name can not be blank!");
			}
			
			if(applicant.getEmailAddress() == "") {
				errors.reject("emailAddress", "Email address can not be blank!");
			}
			
			if(applicant.getLogin().getPassword() == "") {
				errors.reject("login.password", "Password can not be blank!");
			}
			
			if(!(applicant.getLogin().getPassword().equals(applicant.getLogin().getConfirmPassword()))) {
				errors.reject("login.confirmPassword","Password do not match!");
			}
			
			if(list.size()>0) {
				errors.reject("userName","You have an account with us, If you forget your password," +
						"request a new password");
			}
			
			return;
		}
		
		
	}
	
}
