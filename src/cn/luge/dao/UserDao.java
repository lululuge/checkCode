package cn.luge.dao;

import cn.luge.domain.User;
import cn.luge.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDao {
    private JdbcTemplate template;

    {
        try {
            template = new JdbcTemplate(JDBCUtils.getDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User login(User loginUser) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
