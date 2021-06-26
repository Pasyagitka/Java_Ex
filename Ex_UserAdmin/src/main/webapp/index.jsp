<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <form action="Servlet" method="post">
        <div>
            <input type="radio" id="User" name="role" value="User" checked>
            <label for="User">User</label>
        </div>
        <div>
            <input type="radio" id="Admin" name="role" value="Admin">
            <label for="Admin">Admin</label>
        </div>
        <input type="text" name="Password" placeholder="Введите пароль">
        <input type="submit">
    </form>
</body>
</html>