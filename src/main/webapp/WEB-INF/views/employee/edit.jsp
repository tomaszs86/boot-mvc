<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>


<form:form action="edit" method="post" commandName="employeeForm">
     <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="contactNumber">Contact Number</form:label></td>
            <td><form:input path="contactNumber"/></td>
            <td><form:errors path="contactNumber"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
            <td><form:hidden path="id" /></td>
        </tr>
    </table>
</form:form>



</body>

</html> 