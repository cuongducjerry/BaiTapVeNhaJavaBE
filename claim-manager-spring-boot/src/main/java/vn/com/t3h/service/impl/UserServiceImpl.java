package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.mapper.UserMapper;
import vn.com.t3h.repository.UserRepository;
import vn.com.t3h.service.UserService;
import vn.com.t3h.service.dto.UserDTO;
import vn.com.t3h.service.dto.response.BaseResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public BaseResponse<List<UserDTO>> getUsers(
                                                String code,
                                                LocalDate createdDate,
                                                String address,
                                                Pageable pageable) {

        if (StringUtils.isEmpty(code)){
            code = null;
        }
        if (StringUtils.isEmpty(address)){
            address = null;
        }
        Page<UserEntity> pageEntity = this.userRepository.findCondition(code, createdDate, address, pageable);
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();

        userDTOs = pageEntity.map(entity -> userMapper.toDto(entity)).stream().toList();
        BaseResponse<List<UserDTO>> response = new BaseResponse<>();
        response.setData(userDTOs);
        response.setMessage("Success");
        response.setCode(HttpStatus.OK.value()); // 200
        response.setTotalElement(pageEntity.getTotalElements());
        response.setTotalPage(pageEntity.getTotalPages());
        response.setPageSize(pageable.getPageSize());
        response.setPageIndex(pageable.getPageNumber());
        return response;

    }
}
