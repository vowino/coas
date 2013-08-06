package cs.mum.validation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import cs.mum.model.ApplicantLogin;
import cs.mum.services.ApplicantLoginService;

@Service
public class LoginValidator implements Validator {
	@Autowired
	private ApplicantLoginService applicantLoginService;

	public void setApplicantLoginService(
			ApplicantLoginService applicantLoginService) {
		this.applicantLoginService = applicantLoginService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ApplicantLogin.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ApplicantLogin applicantLogin = (ApplicantLogin) target;
		List<ApplicantLogin> list = applicantLoginService
				.getApplicantLoginByUsernamePwd(applicantLogin.getUserName(),
						applicantLogin.getPassword());
		if (applicantLogin.getUserName() == ""
				|| applicantLogin.getPassword() == "" || list.size() != 1) {
			errors.reject("password", "Wrong User name or Password!");
			return;
		}
	}

	public void validateRecoverAccount(Object target, Errors errors) {
		ApplicantLogin applicantLogin = (ApplicantLogin)target;
		List<ApplicantLogin> list = applicantLoginService.
				getApplicantByEmailAddress(applicantLogin.getUserName());
		if(applicantLogin.getUserName() == "" || list.size() != 1) {
			if(applicantLogin.getUserName() == "") {
				errors.reject("userName", "Email Address can not be blank!");
				return;
			}
			
			if(list.size() != 1) {
				errors.reject("userName", "Problem with Email Address!");
				return;
			}
		}
	}
	
	public void validateChangePassword(Object target, Errors errors, String email) {
		ApplicantLogin applicantLogin = (ApplicantLogin)target;
		List<ApplicantLogin> list = applicantLoginService.
				getApplicantByEmailAddress(email);
		if(applicantLogin.getPassword() == "" || applicantLogin.getConfirmPassword() == "" || 
				applicantLogin.getNewPassword() == "") {
			if(applicantLogin.getPassword() == "") {
				errors.reject("password", "Password can not be blank!");
			}
			
			if(applicantLogin.getConfirmPassword() == "") {
				errors.reject("confirmPassword", "Re-type Password can not be blank!");
			}
			
			if(applicantLogin.getNewPassword() == "") {
				errors.reject("newPassword", "New Password can not be blank!");
			}
			
			if(!applicantLogin.getPassword().equals(list.get(0).getPassword())) {
				errors.reject("password", "Old password is not correct!");
			}
			
			if(!applicantLogin.getConfirmPassword().equals(applicantLogin.getNewPassword())) {
				errors.reject("newPassword", "New password and Re-type password does not match!");
			}
			return;
		}
	}

}
