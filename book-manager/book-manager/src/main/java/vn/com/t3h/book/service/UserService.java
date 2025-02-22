package vn.com.t3h.book.service;

import vn.com.t3h.book.model.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> getAllUsers();

    UserModel findUserByUserAndPassword(String username, String password);

    UserModel findUserById(Integer userId);

    int deleteUserById(Integer userId);

    int updateUser(UserModel user);

    int addUser(UserModel user);

}
