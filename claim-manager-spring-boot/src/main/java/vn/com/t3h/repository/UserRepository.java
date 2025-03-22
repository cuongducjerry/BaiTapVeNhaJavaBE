package vn.com.t3h.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.t3h.entity.UserEntity;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value = "select u from UserEntity u" +
            " where (:code is null or u.code = :code) " +
            "and (:createdDate is null or u.createdDate = :createdDate) " +
            "and (:address is null or u.address = :address)"
    )
    Page<UserEntity> findCondition(
            @Param("code") String code,
            @Param("createdDate") LocalDate createdDate,
            @Param("address") String address,
            Pageable pageable);

}
