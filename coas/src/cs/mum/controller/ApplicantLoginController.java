package cs.mum.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
			helper.sendMail(applicantLogin.getUserName(), pwd, "Account Recovery");
			return "redirect:/";
		}
		
	}
}
