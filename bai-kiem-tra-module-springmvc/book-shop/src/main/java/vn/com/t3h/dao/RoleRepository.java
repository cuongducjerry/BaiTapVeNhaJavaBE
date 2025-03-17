package vn.com.t3h.dao;

import vn.com.t3h.entity.RoleEntity;

import java.util.List;
import java.util.Set;

public interface RoleRepository {
    RoleEntity findByRoleNameIn(String roleNames);
}
