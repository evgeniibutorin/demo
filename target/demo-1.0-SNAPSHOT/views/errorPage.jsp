<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII" isErrorPage="true"%>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
Hi There, error code is <%=response.getStatus() %><br>
<p>Type: <%= exception%></p><br>
Please go to <a href="/">home page</a>
</body>
</html>