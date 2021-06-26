<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<div id="login">
    <form id="login_form" method="post" action="logging-servlet">
        <div>
            <label>Login</label>
        </div>
        <div>
            <input type="text" name="login" placeholder="Login">
        </div>
        <div>
            <input type="submit"  name="commit" value="SINGIN">
        </div>
    </form>
    </div>
</div>
</body>
</html>
