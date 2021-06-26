<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <form action="Servlet" method="post">
        <label>Сейчас 2021 год?</label>
        <input type="radio" name="year" value="yes">Yes
        <input type="radio" name="year" value="no">No
        <br>
        <label>Сейчас июнь?</label>
        <input type="radio" name="month" value="yes">Yes
        <input type="radio" name="month" value="no">No
        <br>
        <input type="submit" value="check">
    </form>
</body>
</html>