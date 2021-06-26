<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Index</title>
</head>
<body>
    <form action="index-servlet" method="post">
        <input type="submit" name="Next">
    </form>
    <div>
        <table>
            <tr><th>Title</th><th>Author</th><th>Year</th><th>Pages</th></tr>
            <c:forEach var="item" items="${requestScope.DBlist}">
                <tr>
                    <td>${item.book_name}</td>
                    <td>${item.author}</td>
                    <td>${item.publication_year}</td>
                    <td>${item.pages}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
