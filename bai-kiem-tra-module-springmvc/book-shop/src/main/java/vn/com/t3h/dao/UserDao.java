package vn.com.t3h.dao;

import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.model.UserDTO;

import java.util.List;

public interface UserDao {

    List<UserEntity> findAll();

    UserEntity findById(long id);

    long addUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(long id);

    void updateUserWithIdentity(UserEntity user);

    List<UserEntity> listUsersWithTarget(String username, String phone, String email, String address, String identityCard, List<String> roleNames);

}
