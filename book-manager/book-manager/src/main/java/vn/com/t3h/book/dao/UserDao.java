package vn.com.t3h.book.dao;

import vn.com.t3h.book.model.UserModel;

import java.util.List;

public interface UserDao {

    List<UserModel> getAllUsers();

    UserModel findUserByUserNameAndPassword(String username, String password);

    UserModel findUserById(Integer userId);

    int deleteUserById(Integer userId);

    int updateUser(UserModel userModel);

    int addUser(UserModel userModel);

}
