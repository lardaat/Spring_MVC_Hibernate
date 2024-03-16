package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {
    void create(User user);
    User read(Long id);
    void update(User user);
    void delete(User user);
    List<User> getList();
}
