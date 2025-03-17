package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.IdentityCardRepository;
import vn.com.t3h.dao.RoleRepository;
import vn.com.t3h.entity.IdentityCardEntity;
import vn.com.t3h.service.IdentityCardService;

@Service
public class IdentityCardServiceImpl implements IdentityCardService {

    @Autowired
    @Qualifier("identityCardHibernateRepositoryImpl")
    private IdentityCardRepository identityCardRepository;

    @Override
    public long addIdentityCard(IdentityCardEntity identityCard) {
        return this.identityCardRepository.addIdentityCard(identityCard);
    }

    @Override
    public IdentityCardEntity findIdentityById(long id) {
        return this.identityCardRepository.findIdentityById(id);
    }
}
