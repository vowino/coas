package cs.mum.controller;

import javax.servlet.http.HttpServletRequest;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs.mum.model.Applicant;
import cs.mum.model.ApplicantLogin;
import cs.mum.services.ApplicantLoginService;
import cs.mum.services.ApplicantService;
import cs.mum.validation.ApplicantValidator;

@Controller
public class ApplicantController {
	@Autowired
	private ApplicantService applicantService;
	@Autowired
	private ApplicantLoginService applicantLoginService;
	@Autowired
	ApplicantValidator applicantValidator;
	
	@RequestMapping(value="/register.html")
	public String registerApplicant(Model model) {
		Applicant applicant = new Applicant();
		model.addAttribute("applicantBean", applicant);
		return "register";
	}
	@RequestMapping(value="register.html", method=RequestMethod.POST)
	public String registerApplicant(@ModelAttribute("applicantBean") Applicant applicantBean, 
			BindingResult result,HttpServletRequest req, 
			@RequestParam("recaptcha_challenge_field") String challenge,
	        @RequestParam("recaptcha_response_field") String response,
	        RedirectAttributes redirect) {
		applicantValidator.validate(applicantBean, result);
		// Validate the reCAPTCHA
	    String remoteAddr = req.getRemoteAddr();
	    ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	    
	 // Probably don't want to hardcode your private key here but
	    // just to get it working is OK...
	    reCaptcha.setPrivateKey("6Ld9WeUSAAAAABHtcI_tBaS8DICZPS12J-dmK6CG ");
	    
	    ReCaptchaResponse reCaptchaResponse =
	            reCaptcha.checkAnswer(remoteAddr, challenge, response);
	    
	    if (!reCaptchaResponse.isValid()) {
	        FieldError fieldError = new FieldError(
	            "applicantBean",
	            "captcha",
	            response,
	            false,
	            new String[] { "errors.badCaptcha" },
	            null,
	            "Please try again.");
	        result.addError(fieldError);
	    }
	    
	    // If there are errors, then validation fails.
	    /*if (result.hasErrors()) {
	        String path = applicantBean.getPagePath();
	        log.debug("Form validation error; forwarding to " + path);
	        return "forward:" + path;
	    }*/
	    
		if(result.hasErrors()) {
			return "register";
		}else{
			applicantService.insertApplicant(applicantBean);
			
			ApplicantLogin login = new ApplicantLogin(applicantBean.getEmailAddress(),
					applicantBean.getLogin().getPassword(), applicantBean.getLogin().getPassword(), applicantBean);
			applicantLoginService.insertApplicantLogin(login);
			redirect.addFlashAttribute("newAppMsg", "Successfull Registered, " +
					"Go to your email for Account activation!");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/regVerification/{regverify}")
	public String regmailVerification(@PathVariable String regverify) {
		Applicant applicant = applicantService.getApplicantByRegVerify(regverify);
		applicant.setStatus(true);
		applicant.setRegVerification("Y");
		applicantService.updateApplicant(applicant);
		return "redirect:/";
	}
}
