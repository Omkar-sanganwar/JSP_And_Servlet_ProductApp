<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Display Products</title>
</head>
<body>
    <h1>Product List</h1>
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <c:forEach var="row" items="${resultSet}">
            <tr>
                <td>${row.pid}</td>
                <td>${row.name}</td>
                <td>${row.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
