<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-14 col-md-offset-14">
<h3>Student form consist of following fields.</h3>
	<c:forEach var="i" begin="0" end="4">
	   <div class="form-group">
	   	 <label for="exampleInputEmail1">${studentFormFields[i]}</label>
	   </div>	
	</c:forEach>
</div>
</body>
</html>
