package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import vn.com.t3h.dao.RoleRepository;
import vn.com.t3h.entity.RoleEntity;
import vn.com.t3h.service.RoleService;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Qualifier("roleHibernateRepositoryImpl")
    private RoleRepository roleRepository;


    @Override
    public RoleEntity findByRoleNameIn(String roleNames) {
        return this.roleRepository.findByRoleNameIn(roleNames);
    }
}
