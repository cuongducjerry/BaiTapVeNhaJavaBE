package vn.com.t3h.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.t3h.entity.ClaimEntity;
import vn.com.t3h.entity.UserEntity;

import java.time.LocalDate;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    @Query(value ="select u from UserEntity u " +
            " where (:userCode is null or u.code = :userCode) " +
            "and (:fromDate is null or u.createdDate >= :fromDate) " +
            "and (:toDate is null or u.createdDate <= :toDate) " +
            "and (:phone is null or u.phone = :phone)"
    )
    Page<UserEntity> findCondition(
            @Param("userCode")String userCode,
            @Param("fromDate") LocalDate fromDate,
            @Param("toDate") LocalDate toDate,
            @Param("phone") String phone,
            Pageable pageable);

}
