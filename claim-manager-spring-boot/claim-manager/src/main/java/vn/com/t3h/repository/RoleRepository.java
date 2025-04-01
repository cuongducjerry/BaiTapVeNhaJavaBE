package vn.com.t3h.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.com.t3h.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByCodeAndDeletedIsFalse(String code);

}
