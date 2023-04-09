package peaksoft.service;

import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDaoJdbcImpl check = new UserDaoJdbcImpl();
    public void createUsersTable() {
        check.createUsersTable();
    }

    public void dropUsersTable() {
        check.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        check.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        check.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return check.getAllUsers();
    }

    public void cleanUsersTable() {
        check.cleanUsersTable();
    }
}
