package dao.impl;

import dao.MessageDao;
import model.Message;
import model.User;
import org.hsqldb.lib.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import util.GravatarUtil;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MessageDaoImpl implements MessageDao {
    private static final String GRAVATAR_DEFAULT_IMAGE_TYPE = "monsterid";
    private static final int GRAVATAR_SIZE = 48;
    private NamedParameterJdbcTemplate template;

    @Autowired
    public MessageDaoImpl(DataSource ds){
        template = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public List<Message> getUserTimelineMessages(User user) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", user.getId());

        String sql =  "select message.*, user.* from message, user where " +
                "user.user_id = message.author_id and user.user_id = :id " +
                "order by message.pub_date desc";
        List<Message> query = template.query(sql, params, messageMapper);

        return query;
    }

    @Override
    public List<Message> getUserFullTimelineMessages(User user) {
        return null;
    }

    @Override
    public List<Message> getPublicTimelineMessages() {
        return null;
    }

    @Override
    public void insertMessage(Message m) {

    }

    private RowMapper<Message> messageMapper = (rs, rowNum) -> {
        Message m = new Message();

        m.setId(rs.getInt("message_id"));
        m.setUserId(rs.getInt("author_id"));
        m.setUsername(rs.getString("username"));
        m.setText(rs.getString("text"));
        m.setPubDate(rs.getTimestamp("pub_date"));
        m.setGravatar(GravatarUtil.gravatarURL(rs.getString("email"), GRAVATAR_DEFAULT_IMAGE_TYPE, GRAVATAR_SIZE));

        return m;
    };
}
