<%@ page import="DataBase.UsersOperation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddOK</title>
</head>
<body>
   
   <%
    request.setCharacterEncoding("utf-8");
	String nickname=request.getParameter("nickname");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	UsersOperation users = new UsersOperation();
    users.insertUsers(nickname,password,email);
    %>
   
    <%
        out.print("Welcome!!" + nickname +"!");
        response.sendRedirect("homePage.jsp");
    %>

</body>
</html>