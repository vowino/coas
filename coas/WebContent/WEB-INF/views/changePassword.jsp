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
			<c:url var="logoutUrl" value="/doLogout/"/>
			<h1><span class="blue-text">Computer Professionals Program</span></h1>
			<h3>Maharishi University of Management, <span class="white-text">USA
			<a style="color: white" href="${logoutUrl}">Logout(${email})</a></span></h3>
		</header><!--header end-->
		<nav id = "menu">
			<ul>
				<c:url var="homeUrl" value="/"/>
				<li class="menuitem"><a href="${homeUrl}">Home</a></li>
			</ul>
	     </nav><!--menu end-->
		
	<section>
	<c:url var="changePassword" value="/changePassword"/>
			<h2>Change Password</h2>
			<form:form action="${changePassword}" method="POST" commandName="changePassword">
				<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
				<p>
					<form:label path="password">Old Password:</form:label>
					<form:input type="password" path="password" id="password" value=""/>
				</p>
				
				<p>
					<form:label path="newPassword">New Password:</form:label>
					<form:input type="password" path="newPassword" id="newPassword" value=""/>
				</p>
				<p>
					<form:label path="confirmPassword">Re-type Password:</form:label>
					<form:input type="password" path="confirmPassword" id="confirmPassword" value=""/>
				</p>
				
				<p>
					<input type="submit" value="Submit">
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