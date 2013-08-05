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
		<nav id = "menu">
			<ul>
				<c:url var="homeUrl" value="/"/>
				<li class="menuitem"><a href="${homeUrl}">Home</a></li>
			</ul>
	     </nav><!--menu end-->
		
	<section>
	<c:url var="recoverMyAccountUrl" value="/recoverMyAccount"/>
			<h2>Recover Your Account</h2>
			<form:form action="${recoverMyAccount}" method="POST" commandName="recoverAccount">
				<form:errors path="*" cssClass="errorblock" element="div"></form:errors>
				<p>
					<form:label path="userName">Email Address:</form:label>
					<form:input type="email" path="userName" id="email" value=""/>
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