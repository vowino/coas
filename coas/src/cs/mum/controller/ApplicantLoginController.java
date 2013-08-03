package cs.mum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cs.mum.model.ApplicantLogin;
import cs.mum.services.ApplicantLoginService;
import cs.mum.validation.LoginValidator;

@Controller
public class ApplicantLoginController {
	@Autowired
	private ApplicantLoginService applicantLoginService;
	@Autowired
	LoginValidator loginValidate;
	
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
				//request.getSession().setAttribute("username", applicantLogin.getUserName());
				//request.getSession().setAttribute("uid", applicantLogin.getApplicant().getId());
				displayPage = "Thanks";// we're supposed to return the menus
			} else {
				flag = false;
				displayPage = "login";// if the login failed
			}
	
			return displayPage;
		}

	}
	@RequestMapping(value="/doLogout")
	public String doLogout(HttpServletRequest request) {
		//controll the session
		//request.getSession().removeAttribute("username");
		//request.getSession().removeAttribute("uid");
		return "redirect:/";
	}
}
