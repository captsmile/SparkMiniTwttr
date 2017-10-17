package dao;

import model.Message;
import model.User;

import java.util.List;

public interface MessageDao {
    List<Message> getUserTimelineMessages(User user);

    List<Message> getUserFullTimelineMessages(User user);

    List<Message> getPublicTimelineMessages();

    void insertMessage(Message m);
}
