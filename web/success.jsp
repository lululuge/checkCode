<%@ page import="cn.luge.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h1><%User user = (User) request.getSession().getAttribute("user");%>
        <%=user.getUsername() + ",欢迎你！"%>
    </h1>
</body>
</html>
