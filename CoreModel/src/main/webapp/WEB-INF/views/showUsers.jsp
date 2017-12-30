<%--
  Created by IntelliJ IDEA.
  User: Luther
  Date: 2017/4/16
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有的用户</title>
</head>
<body>
<form>
    <table>
        <c:forEach var="user" items="${list}">
            <tr>
                <td>${user.userid}</td>
                <td>${user.name}</td>
                <td>${user.depid}</td>
                <td>${user.sex}</td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>
