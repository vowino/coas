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
	<c:url var="logoutUrl" value="/doLogout"/>
			<h3>Home</h3>
			Welcome Home page coming soon!!!!!!!!!!!!!!!!!!!!!!!<a href="${logoutUrl}">Logout</a>
    </section><!--content end-->
	
</div><!--container end-->
</body>

<div style ="clear:both"></div>
<footer>
	Copyright 2013 Nolle Group.
</footer>
</html>