package vn.com.t3h.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.com.t3h.service.UserService;
import vn.com.t3h.service.dto.UserDTO;
import vn.com.t3h.service.dto.response.BaseResponse;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<UserDTO>>> getListUsers(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) LocalDate createdDate,
            @RequestParam(required = false) String address,
            Pageable pageable){

        BaseResponse<List<UserDTO>> response = userService.getUsers(code, createdDate, address, pageable);
        return ResponseEntity.ok(response);

    }

}
