<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>



<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Contact number</th>
    </tr>
    <c:if test="${not empty employees}">
	<c:forEach items="${employees}" var="employee">
	    <tr>      
	        <td>${employee.id}</td>
	        <td>${employee.name}</td>
	        <td>${employee.contactNumber}</td>
	    </tr>
	</c:forEach>
	</c:if>
</table>


</body>

</html> 