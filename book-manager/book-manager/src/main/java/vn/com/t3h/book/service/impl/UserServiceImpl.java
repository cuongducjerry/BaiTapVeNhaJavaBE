package vn.com.t3h.book.service.impl;

import vn.com.t3h.book.dao.UserDao;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.service.UserService;
import vn.com.t3h.book.util.PasswordUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public UserModel findUserByUserAndPassword(String username, String password) {
        String passwordEncrypt = PasswordUtils.encrypt(password);
        return userDao.findUserByUserNameAndPassword(username, passwordEncrypt);
    }

    @Override
    public UserModel findUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public int deleteUserById(Integer userId) {
        return userDao.deleteUserById(userId);
    }

    @Override
    public int updateUser(UserModel user) {
        return userDao.updateUser(user);
    }

    @Override
    public int addUser(UserModel user) {
        return userDao.addUser(user);
    }

}
