package vn.com.t3h.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.RoleRepository;
import vn.com.t3h.entity.RoleEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository("roleHibernateRepositoryImpl")
public class RoleRepositoryImpl implements RoleRepository {

    private final SessionFactory sessionFactory;

    public RoleRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public RoleEntity findByRoleNameIn(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM RoleEntity r LEFT JOIN FETCH r.users WHERE r.roleName = :roleName";
            Query<RoleEntity> query = session.createQuery(hql, RoleEntity.class);
            query.setParameter("roleName", roleName);
            return query.uniqueResult(); // Hoặc query.list() nếu có nhiều kết quả
        }
    }
}
