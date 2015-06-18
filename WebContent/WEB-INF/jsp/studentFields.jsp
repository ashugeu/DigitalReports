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
<h3><b>Student form consist of following fields.</b></h3>
	<c:forEach var="i" begin="0" end="4">
	   <div class="form-group">
	   	 <label for="exampleInputEmail1">${studentFormFields[i]}</label>
	   </div>	
	</c:forEach>
</div>
<br><br>
<h3><b>Add new Fields:<b></h3>
<form action="addFields.rpc?user=${user}&id=103" method="post">
	<div class="form-group">
	   	 <label for="exampleInputEmail1">Field Name</label>
	   	 <input type="text"  class="form-control" name="field" placeholder="field"/><br>
    </div>	
    <div class="form-group">
	   	 <label for="exampleInputEmail1">Field type</label><br>
	   	 <select name="type">
			<option value="text">Text</option>
			<option value="number">Number</option>
			<option value="date">Date</option>
		 </select>
    </div>	
    <input type="submit"/>
</form>
</body>
</html>
