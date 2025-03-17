package vn.com.t3h.service;

import vn.com.t3h.entity.IdentityCardEntity;
import vn.com.t3h.entity.UserEntity;

public interface IdentityCardService {

    long addIdentityCard(IdentityCardEntity identityCard);

    IdentityCardEntity findIdentityById(long id);
}
