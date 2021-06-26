<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" uri="http://pasyagitka.meow" %>

<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <form>
        <input type="text" name="checktext" placeholder="Ввод..."><br/>
        <input value="check" type="submit" name="checksubmit">
    </form>
    <p>${param.checktext} -> ${t:stringCheck(param.checktext)}</p>
</body>
</html>