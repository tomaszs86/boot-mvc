<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title of the document</title>
</head>

<body>


   <table>
        <tr>
            <td>Name:</td>
            <td>${employeeForm.name}</td>
        </tr>
        <tr>
            <td>ID :</td>
            <td>${employeeForm.id}</td>
        </tr>
        <tr>
            <td>Contact Number :</td>
            <td>${employeeForm.contactNumber}</td>
        </tr>
    </table>


</body>

</html> 