package cn.luge.test;

import cn.luge.dao.UserDao;
import cn.luge.domain.User;
import org.junit.Test;

public class TestLogin {
    @Test
    public void testLogin() {
        User loginUser = new User();
        loginUser.setUsername("luzan");
        loginUser.setPassword("000000");
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
