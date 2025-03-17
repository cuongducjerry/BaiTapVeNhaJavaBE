package vn.com.t3h.dao;

import vn.com.t3h.entity.IdentityCardEntity;

public interface IdentityCardRepository {
    long addIdentityCard(IdentityCardEntity identityCard);

    IdentityCardEntity findIdentityById(long id);
}
