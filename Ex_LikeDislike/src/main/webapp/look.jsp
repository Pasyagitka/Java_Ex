<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String url = "jdbc:sqlserver://localhost;database=Ex_Like;integratedSecurity=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from LikeOrDislike");
        resultSet.next();
    %>
    <h3><%= resultSet.getString("text")%>   Лайки <%= resultSet.getInt("like")%>   Дизлайки <%= resultSet.getInt("dislike")%></h3>
<form action="like-servlet" method="post">
    <input type="submit" value="like"/>
</form>
<form action="dislike-servlet" method="post">
    <input type="submit" value="dislike"/>
</form>
</body>
</html>
