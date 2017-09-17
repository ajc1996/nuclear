package nuclear.service;

import nuclear.interfaces.MessageSender;
import nuclear.model.UserNu;

import java.util.List;

public interface UserNuService {

    List<UserNu> userquery();
    boolean login(UserNu userNu, MessageSender messageSender);
    UserNu findByUname(UserNu userNu);
    UserNu findById(int id);
}
