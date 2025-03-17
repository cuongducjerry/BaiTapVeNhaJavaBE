package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.UserDao;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.model.UserDTO;
import vn.com.t3h.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userHibernateRepositoryImpl")
    private UserDao userDao;

    @Override
    public List<UserEntity> getUsers() {
        return userDao.findAll();
    }

    @Override
    public UserEntity findById(long id) {
        return userDao.findById(id);
    }

    @Override
    public long addUser(UserEntity user) {
        return userDao.addUser(user);
    }

    @Override
    public void updateUser(UserEntity user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void updateUserWithIdentity(UserEntity user) {
        userDao.updateUserWithIdentity(user);
    }

    @Override
    public List<UserEntity> listUserWithTarget(String username, String phone, String email, String address, String identityCard, List<String> roleNames) {
        return userDao.listUsersWithTarget(username, phone, email, address, identityCard, roleNames);
    }




}
