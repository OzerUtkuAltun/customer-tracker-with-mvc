<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM- Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>ID</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
            </tr>

            <c:forEach var="customer" items="#{customers}">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
