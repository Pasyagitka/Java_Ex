<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <form action="Servlet" method="post">
        <label for="divc">Курс</label>
        <div id="divc">
            <input type="radio" id="first" name="course" value="1" checked>
            <label for="first">Первый</label>
        </div>
        <div>
            <input type="radio" id="second" name="course" value="2">
            <label for="second">Второй</label>
        </div>
        <div>
            <input type="radio" id="third" name="course" value="3">
            <label for="third">Третий</label>
        </div>
        <div>
            <input type="radio" id="fourth" name="course" value="4">
            <label for="fourth">Четвертый</label>
        </div>
        <input type="text" name="spec" placeholder="Специальность">
        <input type="text" name="group" placeholder="Группа">
        <input type="submit" name="go" value="GO">
        <input type="submit" name="delete" value="Delete">
    </form>
    <br/>
    <br/>
    <br/>
    <h1>Сохранено</h1>
   <%-- <h2><%=ResultString%></h2>--%>
</body>
</html>