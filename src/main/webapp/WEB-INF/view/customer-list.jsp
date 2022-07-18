<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer List</title>
    <link
            rel="stylesheet"
            href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>CRM- Customer Relationship Manager</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Add Customer"
               onclick="window.location.href='showFormForAdd'; return false;"
               class="add-button"/>
        <table>
            <tr>
                <th>ID</th>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

            <c:forEach var="customer" items="#{customers}">

                <%--                constructing an update link with customer id --%>
                <c:url var="updateLink" value="/customers/showFormForUpdate">
                    <c:param name="customerId" value="${customer.id}"/>
                    <%--                    requestpath?customerId=5   gibi bir şey sağlıyor.--%>
                </c:url>

                <%--                 constructing a delete link with customer id --%>
                <c:url var="deleteLink" value="/customers/delete">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>

                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                        <%--                    displaying the update link--%>
                    <td><a href="${updateLink}">Update</a> |
                        <a href="${deleteLink}"
                           onclick="if ( !(confirm('Are you sure you want to delete this customer?'))) return false;"
                        >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
