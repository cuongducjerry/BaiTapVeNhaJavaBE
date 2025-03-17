package vn.com.t3h.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.UserDao;
import vn.com.t3h.entity.IdentityCardEntity;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.model.UserDTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository("userHibernateRepositoryImpl")
public class UserHibernateRepositoryImpl implements UserDao {

    private final SessionFactory sessionFactory;

    public UserHibernateRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserEntity> findAll() {
        Session session = sessionFactory.openSession();
        String hql = "FROM UserEntity WHERE isDeleted = FALSE"; //
        Query<UserEntity> query = session.createQuery(hql,UserEntity.class);
        List<UserEntity> repositories = query.getResultList();
        session.close();
        return repositories;
    }

    @Override
    public UserEntity findById(long id) {
        Session session = sessionFactory.openSession();
        String hql = "FROM UserEntity WHERE id = :id AND isDeleted = FALSE"; // Chỉ lấy user chưa bị xóa
        Query<UserEntity> query = session.createQuery(hql, UserEntity.class);
        query.setParameter("id", id);
        UserEntity user = query.uniqueResult();
        session.close();
        return user;
    }

    @Override
    public long addUser(UserEntity user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long userId = (Long) session.save(user);  // Trả về ID của user vừa thêm
        transaction.commit();
        session.close();
        return userId;
    }

    @Override
    public void updateUser(UserEntity user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        String hql = "UPDATE UserEntity SET username = :username, password = :password, address = :address, phone = :phone, email = :email WHERE id = :id AND isDeleted = FALSE";
        Query query = session.createQuery(hql);
        query.setParameter("username", user.getUsername());
        query.setParameter("password", user.getPassword());
        query.setParameter("address", user.getAddress());
        query.setParameter("phone", user.getPhone());
        query.setParameter("email", user.getEmail());
        query.setParameter("id", user.getId());

        int result = query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void updateUserWithIdentity(UserEntity user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Lấy user từ database
        UserEntity existingUser = session.get(UserEntity.class, user.getId());

        if (existingUser != null && !existingUser.getIsDeleted()) {
            if (user.getIdentityCard() != null) {
                // Kiểm tra nếu IdentityCardEntity đã tồn tại trong session
                IdentityCardEntity identityCard = session.get(IdentityCardEntity.class, user.getIdentityCard().getId());
                if (identityCard != null) {
                    session.evict(identityCard); // Xóa bản cũ khỏi session để tránh xung đột
                }

                IdentityCardEntity mergedIdentityCard = (IdentityCardEntity) session.merge(user.getIdentityCard());
                existingUser.setIdentityCard(mergedIdentityCard);
            }

            session.merge(existingUser); // Sử dụng merge thay vì update để tránh lỗi session
        }

        transaction.commit();
        session.close();
    }

    @Override
    public void deleteUser(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Cập nhật trạng thái xóa mềm
        String hql = "UPDATE UserEntity SET isDeleted = TRUE WHERE id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);

        int result = query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public List<UserEntity> listUsersWithTarget(String username, String phone, String email,
                                                String address, String identityCard, List<String> roleNames) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Khởi tạo câu HQL
        String hql = "SELECT DISTINCT u FROM UserEntity u LEFT JOIN FETCH u.roles r";
        List<String> conditions = new ArrayList<>();

        // Thêm điều kiện chỉ khi có giá trị
        if (username != null) conditions.add("u.username LIKE :username");
        if (phone != null) conditions.add("u.phone LIKE :phone");
        if (email != null) conditions.add("u.email LIKE :email");
        if (address != null) conditions.add("u.address LIKE :address");
        if (identityCard != null) conditions.add("u.identityCard.identityNumber LIKE :identityCard");
        if (roleNames != null && !roleNames.isEmpty()) conditions.add("r.roleName IN (:roleNames)");

        // Nếu có điều kiện, thêm WHERE
        if (!conditions.isEmpty()) {
            hql += " WHERE " + String.join(" AND ", conditions);
        }

        Query query = session.createQuery(hql);

        // Gán giá trị cho từng tham số
        if (username != null) query.setParameter("username", "%" + username + "%");
        if (phone != null) query.setParameter("phone", "%" + phone + "%");
        if (email != null) query.setParameter("email", "%" + email + "%");
        if (address != null) query.setParameter("address", "%" + address + "%");
        if (identityCard != null) query.setParameter("identityCard", "%" + identityCard + "%");
        if (roleNames != null && !roleNames.isEmpty()) query.setParameterList("roleNames", roleNames);

        List<UserEntity> users = query.getResultList();
        transaction.commit();
        session.close();

        return users;
    }


}
