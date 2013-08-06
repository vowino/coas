<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%-- <%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
 <%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
 
 <%@ page import="net.tanesha.recaptcha.ReCaptchaImpl" %>
    <%@ page import="net.tanesha.recaptcha.ReCaptchaResponse" %>
    
    <%
        String remoteAddr = request.getRemoteAddr();
        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("your_private_key");

        String challenge = request.getParameter("recaptcha_challenge_field");
        String uresponse = request.getParameter("recaptcha_response_field");
        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

        if (reCaptchaResponse.isValid()) {
          out.print("Answer was entered correctly!");
        } else {
          out.print("Answer is wrong");
        }
      %> --%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<title>Blue Developer Directory</title>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
	font-weight: bold;
}
</style>

</head>
<body>
	<div id="container">
		<header>
			<h1><span class="blue-text">Computer Professionals Program</span></h1>
			<h3>Maharishi University of Management, <span class="white-text">USA</span></h3>
		</header><!--header end-->
		
		<nav id = "menu">
			<ul>
				<c:url var="homeUrl" value="/"/>
				<li class="menuitem"><a href="${homeUrl}">Home</a></li>
			</ul>
	     </nav><!--menu end-->
	<section>
			<h3>Register</h3>
			<c:url var="registerUrl" value="register.html"/>
			<form:form method="post" action="${registerUrl}" commandName="applicantBean">
				<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
				<p>
					<form:label path="firstName">First Name:</form:label>
					<form:input type="text" path="firstName" id="firstName"/>
				</p>
				<p>
					<form:label path="middleName">Middle Name:</form:label>
					<form:input type="text" path="middleName" id="middleName"/>
				</p>
				<p>
					<form:label path="lastName">Last Name:</form:label>
					<form:input type="text" path="lastName" id="lastName"/>
				</p>
				<p>
					<form:label path="emailAddress">Email Address: </form:label>
					<form:input type="email" path="emailAddress" id="emailAddress"/>
				</p>
				<p>
					<form:label path="login.password">Password: </form:label>
					<form:input type="password" path="login.password" id="password"/>
				</p>
				<p>
					<form:label path="login.confirmPassword">Confirm Password: </form:label>
					<form:input type="password" path="login.confirmPassword"/>
				</p>
			
				<p>
					<input type="submit" value="Register">
				</p>
				
       			<script type="text/javascript"	src="http://api.recaptcha.net/challenge?k=6Ld9WeUSAAAAAD2BNqya9ZEyC_jvUjDY4tQ_-016">
				</script>
				<noscript>
    			<iframe src="http://api.recaptcha.net/noscript?k=6Ld9WeUSAAAAAD2BNqya9ZEyC_jvUjDY4tQ_-016"
        			height="300" width="500" frameborder="0"></iframe><br>
    			<textarea name="recaptcha_challenge_field" rows="3" cols="40">
    			</textarea>
    			<input type="hidden" name="recaptcha_response_field" value="manual_challenge">
				</noscript>

			</form:form>
    </section><!--content end-->
	
</div><!--container end-->
</body>

<div style ="clear:both"></div>
<footer>
	Copyright 2013 Nolle Group.
</footer>
</html>
