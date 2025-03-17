package vn.com.t3h.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.com.t3h.dao.IdentityCardRepository;
import vn.com.t3h.entity.IdentityCardEntity;
import vn.com.t3h.entity.UserEntity;

@Repository("identityCardHibernateRepositoryImpl")
public class IdentityCardRepositoryImpl implements IdentityCardRepository {

    private final SessionFactory sessionFactory;

    public IdentityCardRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public long addIdentityCard(IdentityCardEntity identityCard) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long identityId = (Long) session.save(identityCard);
        transaction.commit();
        session.close();
        return identityId;
    }

    @Override
    public IdentityCardEntity findIdentityById(long id) {
        Session session = sessionFactory.openSession();
        String hql = "FROM IdentityCardEntity WHERE id = :id AND isDeleted = FALSE"; // Chỉ lấy user chưa bị xóa
        Query<IdentityCardEntity> query = session.createQuery(hql, IdentityCardEntity.class);
        query.setParameter("id", id);
        IdentityCardEntity identityCard = query.uniqueResult();
        session.close();
        return identityCard;
    }
}
