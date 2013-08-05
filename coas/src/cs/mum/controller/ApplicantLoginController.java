package cs.mum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cs.mum.mb.Helper;
import cs.mum.model.ApplicantLogin;
import cs.mum.services.ApplicantLoginService;
import cs.mum.validation.LoginValidator;

@Controller
@SessionAttributes("email")
public class ApplicantLoginController {
	@Autowired
	private ApplicantLoginService applicantLoginService;
	@Autowired
	LoginValidator loginValidate;
	@Autowired
	private Helper helper;
	
	@RequestMapping(value = "/")
	public String login(@ModelAttribute("applicantlogin") ApplicantLogin applicantLogin,BindingResult result) {
		return "login";
	}

	@RequestMapping(value = "/logginApplication", method = RequestMethod.POST)
	public String login(@ModelAttribute("applicantlogin") ApplicantLogin applicantLogin,BindingResult result,
			Model model,HttpServletRequest request) {
		loginValidate.validate(applicantLogin, result);
		if(result.hasErrors()) {
			return "login";
		}else{
			boolean flag = false;
			String displayPage = "";
	
			List<ApplicantLogin> myList = applicantLoginService
					.getApplicantLoginByUsernamePwd(applicantLogin.getUserName(), applicantLogin.getPassword());
			model.addAttribute("login", flag);
			if (myList.size() > 0) {
				flag = true;
				model.addAttribute("email", applicantLogin.getUserName());
				displayPage = "Thanks";// we're supposed to return the menus
			} else {
				flag = false;
				displayPage = "login";// if the login failed
			}
	
			return displayPage;
		}

	}
	
	@RequestMapping(value="/doLogout")
	public String doLogout(SessionStatus sessionStatus) {
		//controll the session
		sessionStatus.setComplete();
		return "redirect:/";
	}
	
	@RequestMapping(value="/recoverMyAccount")
	public String recoverMyAccount(@ModelAttribute("recoverAccount") ApplicantLogin applicantLogin,
			BindingResult result) {
		return "recoverMyAccount";
	}
	@RequestMapping(value="/recoverMyAccount", method=RequestMethod.POST)
	public String recoverMyaccount(@ModelAttribute("recoverAccount") ApplicantLogin applicantLogin,
			BindingResult result) {
		loginValidate.validateRecoverAccount(applicantLogin, result);
		if(result.hasErrors()) {
			return "recoverMyAccount";
		}else{
			String pwd = Helper.randomAlphaNumeric(9);
			List<ApplicantLogin> login =applicantLoginService.
					getApplicantByEmailAddress(applicantLogin.getUserName());
			ApplicantLogin pLogin = login.get(0);
			pLogin.setPassword(Helper.md5(pwd));
			applicantLoginService.updateUserLogin(pLogin);
			String mailBody = "Dear "+applicantLogin.getUserName();
				   mailBody+= "\n\n You have requested for Account Recovery service,";
				   mailBody+= ", \n\n Use the following password to Login into your Account: ";
				   mailBody+= pwd;
				   mailBody+= " If you are not aware with this request Please, ";
				   mailBody+= "\n ckick the Link below to Lock your account";
				   mailBody+= "\n\n";
				   mailBody+= " http://localhost:8080/coas/";
				   mailBody+= "suspiciousLock/";
				   mailBody+= Helper.md5(String.valueOf(pLogin.getApplicant().getCreationDate()));
				   mailBody+= "/"+Helper.md5(pwd)+"/";
				   mailBody += "\n\n****************************************************************";
				   mailBody+= "\n\n Thanks\n\n http://www.mum.edu";
			helper.sendMail(applicantLogin.getUserName(), mailBody, "Account Recovery");
			return "redirect:/";
		}
	}
	@RequestMapping(value="/changePassword")
	public String changePassword(@ModelAttribute("changePassword") ApplicantLogin applicantLogin,
			BindingResult result) {
		return "changePassword";
	}
	
	@RequestMapping(value="/changePassword", method=RequestMethod.POST)
	public String changePassword(@ModelAttribute("changePassword") ApplicantLogin applicantLogin, 
			BindingResult result,@ModelAttribute("email") String email) {
		loginValidate.validateChangePassword(applicantLogin, result, email);
		if(result.hasErrors()) {
			return "changePassword";
		}else{
			List<ApplicantLogin> list = applicantLoginService.getApplicantByEmailAddress(email);
			ApplicantLogin login = list.get(0);
			login.setPassword(Helper.md5(applicantLogin.getNewPassword()));
			applicantLoginService.updateUserLogin(login);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/suspiciousLock/option/pwd")
	//option variable is the MD5() for creation date
	public String suspiciousLock(@PathVariable String option, @PathVariable String pwd) {
		return "";
	}
}
