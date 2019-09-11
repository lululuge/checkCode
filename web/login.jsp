<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<script>
    window.onload = function () {
        var img = document.getElementById("img");
        img.onclick = function () {
            img.src = "/test/checkCodeServlet?time=" + new Date().getTime();
        }
    }
</script>
<style>
    div {
        color: red;
    }
</style>
<body>
    <form action="/test/loginServlet" method="post">
        <table>
            <tr>
                <td>请输入用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>请输入密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>请输入验证码：</td>
                <td><input type="text" name="checkCode"></td>
            </tr>
            <tr>
                <td><img id="img" src="/test/checkCodeServlet"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
        </table>
<%--        <span>请输入用户名：</span><input type="text" name="username"><br>--%>
<%--        <span>请输入密码：</span><input type="password" name="password"><br>--%>
<%--        <span>请输入验证码：</span><input type="text" name="checkCode"><br>--%>
<%--        <img id="img" src="/test/checkCodeServlet"><br>--%>
<%--        <input type="submit" value="登录">--%>
    </form>

    <div>
        <%
            String login_error = (String) request.getAttribute("login_error");
        %>
        <%=login_error == null ? "" : login_error%>
    </div>

    <div>
        <%
            String checkCode_error = (String) request.getAttribute("checkCode_error");
        %>
        <%=checkCode_error == null ? "" : checkCode_error%>
    </div>
</body>
</html>
