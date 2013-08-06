<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<title>Compro on-Line Admission System</title>
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
		
	<section>
			<h3>Login</h3>
			
			<p style="color:#264409; border-color:#C6D880; background:#E6EFC2; font-weight: bold;" 
				align="center">${newAppMsg}</p>
			<form:form method="post" action="logginApplication" commandName="applicantlogin">
				<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
				<c:url var="newRegUrl" value="/register.html"/>
				<c:url var="recoverMyAccountdUrl" value="/recoverMyAccount"/>
				<p>
					<form:label path="userName">Email Address: </form:label>
					<form:input type="text" path="userName" id="userName"/>
				</p>
				<p>
					<form:label path="password">Password: </form:label>
					<form:input type="password" path="password"/>
				</p>
				
				<p>
					<a href="${newRegUrl}">Register</a> | 
					<a href="${recoverMyAccountdUrl}">Forget Password</a>
				</p>
			
				<p>
					<input type="submit" value="Login">
				</p>
			</form:form>
    </section><!--content end-->
	
</div><!--container end-->
</body>

<div style ="clear:both"></div>
<footer>
	Copyright 2013 Nolle Group.
</footer>
</html>