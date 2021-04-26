<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Add new user</title>
</head>

<body>
<div>
    <h1>Super app!</h1>
</div>

<div>
<%--    <%--%>
<%--        if (request.getAttribute("userName") != null) {--%>
<%--            out.println("<p>User '" + request.getAttribute("userName") + "' added!</p>");--%>
<%--        }--%>
<%--    %>--%>
    <div>
        <div>
            <h2>Add user</h2>
        </div>

        <form method="post">
            <label>Full name:
                <input type="text" name="name"><br />
            </label>
            <label>Position:
                <input type="text" name="position"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>

<div>
    <button onclick="location.href='/'">Update information </button>
</div>


<table border="2">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Position</td>
    </tr>
<%--    <c:forEach var="employees" items="${employees}">--%>
<%--        <tr>--%>
<%--            <td>${employees.getId()}</td>--%>
<%--            <td>${employees.getName()}</td>--%>
<%--            <td>${employees.getDescription}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
</table>

</body>
</html>