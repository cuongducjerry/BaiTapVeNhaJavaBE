package vn.com.t3h.service;

import vn.com.t3h.entity.RoleEntity;

import java.util.List;
import java.util.Set;

public interface RoleService {
    RoleEntity findByRoleNameIn(String roleNames);
}
