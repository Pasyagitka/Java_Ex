<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <form action="Servlet" method="post">
        <input type="submit" value="POST">
    </form>
    <form action="Servlet" method="get">
        <input type="submit" value="GET">
    </form>
    <p>${requestScope.result}</p>
</body>
</html>