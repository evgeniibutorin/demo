<%--
  Created by IntelliJ IDEA.
  User: BUTORIN
  Date: 21.04.2021
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add name</title>
</head>
<body>
<div>
    <div>
        <h2>What is your name?</h2>
    </div>
    <form method="post" action="sayHello">
        <input type="text"  name="username"/>
        <input type="submit" value="go" onclick="location.href='/sayHello'" />
    </form>
</div>
</body>
</html>
