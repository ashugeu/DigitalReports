<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Login</title>
		<link href="${pageContext.request.contextPath}/resources/mycss/style.css" rel="stylesheet">
	</head>
	<body>
		<div class='form animated flipInX'>
		  <h2>Login To Your Account</h2>
		  <form action='loginValidate.htm' method='post'>
		    <input placeholder='Username' type='text' name='email'>
		    <input placeholder='Password' type='password' name='pass'>
		    <button class='animated infinite pulse'>Login</button>
		    <c:if test="${wrongUserPass == 'False'}">
   					<p>You have entered a wrong username or password.<p>
			</c:if>
		  </form>
		</div>
	</body>
</html>