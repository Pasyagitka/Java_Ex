<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Work</title>
</head>
<body>
    <form action="WorkServlet" method="post">
        <p><h3>Приветствую, ${sessionScope.userlogin}</h3>
        <p><h3>Сумма на счету: </h3><p>${requestScope.sum}<input type="submit" value="GETINFO"></p>
    </form>
    <form action="SumServlet" method="post">
        <input type="text" name="price" value="0" placeholder="Введите сумму"><br>
        <input type="submit" name="pay" value="PAY"><br>
        <input type="submit" name="add" value="ADD"><br>
    </form>
</body>
</html>
