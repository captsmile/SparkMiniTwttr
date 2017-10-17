package dao.impl;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class UserDaoImpl implements UserDao {
    private NamedParameterJdbcTemplate template;

    @Autowired
    public UserDaoImpl(DataSource ds){
        template=new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public User getUserbyUsername(String username) {
        return null;
    }

    @Override
    public void insertFollower(User follower, User followee) {

    }

    @Override
    public void deleteFollower(User follower, User followee) {

    }

    @Override
    public boolean isUserFollower(User follower, User followee) {
        return false;
    }

    @Override
    public void registerUser(User user) {

    }
}
