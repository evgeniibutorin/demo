<%--
  Created by IntelliJ IDEA.
  User: BUTORIN
  Date: 21.04.2021
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<%

    out.println("Hello " + request.getParameter("username"));

%>
</body>
</html>
