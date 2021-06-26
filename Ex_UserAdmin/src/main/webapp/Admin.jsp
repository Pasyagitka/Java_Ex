<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
    <%
        Cookie[] cookies = request.getCookies();
        String ResultString = "";
        for (Cookie cookie: cookies) {
            if (cookie.getName().equals("admin")) {
                ResultString = ResultString + "Последний вход: " + cookie.getValue() + "</br>";
                break;
            }
        }
    %>
    <h1>Hello, Admin</h1>
    <h2><%= ResultString%></h2>
</body>
</html>
