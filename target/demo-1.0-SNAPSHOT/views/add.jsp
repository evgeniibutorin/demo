<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<html>
<head>
    <title>Add new user</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
            <button onclick="location.href='/add'" type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>

<div>
    <button onclick="location.href='/add'">Update information </button>
</div>

<form>
<%--<div class="row">--%>
<%--    <div class="card-panel">--%>
        <table>
            <thead>
            <tr>
                <th>Employee ID</th>
                <th>Name</th>
                <th>Position</th>
            </tr>
            </thead>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td name ="id"><c:out value="${employee.id}"/></td>
                    <td><c:out value="${employee.name}"/></td>
                    <td><c:out value="${employee.position}"/></td>
                    <td>
                        <a href=""><i class="material-icons" name="delete_button">delete</i></a>

                    </td>
                </tr>
            </c:forEach>
        </table>
<%--    </div>--%>
<%--</div>--%>
</form>
<script
        src="https://code.jquery.com/jquery-3.2.1.min.js"
        integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
        crossorigin="anonymous">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>

</body>
</html>