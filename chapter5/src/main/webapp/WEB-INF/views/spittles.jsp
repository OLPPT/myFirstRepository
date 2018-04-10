<%--
  Created by IntelliJ IDEA.
  User: OL-PC
  Date: 2018/03/26
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${spittleList}" var="spittle">
        <li id="spittle_<c:out value="spittle.id"/>">
            <c:out value="${spittle.message}"/>
            <span><c:out value="${spittle.time}"/></span>
            <span>(<c:out value="${spittle.latitude}"/>,<c:out value="${spittle.longitude}"/></span>
        </li>
    </c:forEach>
</body>
</html>
