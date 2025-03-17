package vn.com.t3h.service;

import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.model.UserDTO;

import java.util.List;

public interface UserService {

    List<UserEntity> getUsers();

    UserEntity findById(long id);

    long addUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(long id);

    void updateUserWithIdentity(UserEntity user);

    List<UserEntity> listUserWithTarget(String username, String phone, String email, String address, String identityCard, List<String> roleNames);

}
