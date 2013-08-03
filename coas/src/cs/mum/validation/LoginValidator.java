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

	public void setApplicantLoginService(ApplicantLoginService applicantLoginService) {
		this.applicantLoginService = applicantLoginService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return ApplicantLogin.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ApplicantLogin applicantLogin = (ApplicantLogin)target;
		List<ApplicantLogin> list = applicantLoginService.
				getApplicantLoginByUsernamePwd(applicantLogin.getUserName(), applicantLogin.getPassword());
		if(applicantLogin.getUserName() == "" || applicantLogin.getPassword() == "" || list.size()  != 1) {
			errors.reject("password", "Wrong User name or Password!");
			return;
		}
	}

}
