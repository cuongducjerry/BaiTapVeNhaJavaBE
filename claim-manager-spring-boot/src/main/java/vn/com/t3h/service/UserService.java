package vn.com.t3h.service;

import org.springframework.data.domain.Pageable;
import vn.com.t3h.service.dto.UserDTO;
import vn.com.t3h.service.dto.response.BaseResponse;

import java.time.LocalDate;
import java.util.List;

public interface UserService {

    BaseResponse<List<UserDTO>> getUsers(
        String code,
        LocalDate createdDate,
        String address,
        Pageable pageable
    );

}
