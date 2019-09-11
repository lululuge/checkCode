package cn.luge.servlet;

import cn.luge.dao.UserDao;
import cn.luge.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");
        // 先判断验证码是否正确
        // 获取验证码
        HttpSession session = request.getSession();
        String checkCode_session = (String) session.getAttribute("checkCode_session");
        // 删除该sesison
        session.removeAttribute("checkCode_session");
        if (checkCode_session != null && checkCode_session.equalsIgnoreCase(checkCode)) {
            // 继续比较用户名和密码
            UserDao dao = new UserDao();
            User loginUser = new User();
            loginUser.setUsername(username);
            loginUser.setPassword(password);
            User user = dao.login(loginUser);
            if (user != null) {
                // 登录成功
                // 存储用户信息
                session.setAttribute("user", user);
                // 重定向到success.jsp页面
                response.sendRedirect(request.getContextPath() + "/success.jsp");
            }
            else {
                // 登录失败
                request.setAttribute("login_error", "用户名或密码错误！");
                // 转发到login.jsp页面
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
        else {
            // 验证码错误
            // 存储提示信息
            request.setAttribute("checkCode_error", "验证码错误");
            // 转发到login.jsp页面
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
