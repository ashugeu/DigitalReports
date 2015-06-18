<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-4 col-md-offset-4">
<form action="#" method="post">
	<c:forEach var="i" begin="0" end="${fn:length(studentFormFields)-1}">
	   <div class="form-group">
	   	 <label for="exampleInputEmail1">${studentFormFields[i].field}</label>
	   	 <input type="${studentFormFields[i].type}"  class="form-control" name="${studentFormFields[i].field}" placeholder="${studentFormFields[i].field}"/><br>
	   </div>	
	</c:forEach>
	<input type="submit"/>
</form>
</div>
</body>
</html>

