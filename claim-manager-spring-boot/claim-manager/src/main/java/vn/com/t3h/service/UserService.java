package vn.com.t3h.service;

import org.springframework.data.domain.Pageable;
import vn.com.t3h.service.dto.ClaimDTO;
import vn.com.t3h.service.dto.UserDTO;
import vn.com.t3h.service.dto.response.Response;
import vn.com.t3h.service.dto.response.ResponsePage;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    Response<UserDTO> saveUser(UserDTO user);

    ResponsePage<List<UserDTO>> getUsers(
            String claimCode,
            LocalDate fromDate,
            LocalDate toDate,
            String phone,
            Pageable pageable
    );

}
