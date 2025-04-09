package vn.com.t3h.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.service.UserService;
import vn.com.t3h.service.dto.ClaimDTO;
import vn.com.t3h.service.dto.UserDTO;
import vn.com.t3h.service.dto.response.Response;
import vn.com.t3h.service.dto.response.ResponsePage;
import vn.com.t3h.service.request.RequestDataUser;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public ResponseEntity<Response<UserDTO>> saveUser(@RequestBody UserDTO userDTO) {
        Response<UserDTO> response = userService.saveUser(userDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user")
    public ResponseEntity<ResponsePage<List<UserDTO>>> getPostUsersTarget(
            @RequestBody RequestDataUser requestData,
            Pageable pageable) {

        String userCode = requestData.getUserCode();
        LocalDate fromDate = requestData.getFromDate();
        LocalDate toDate = requestData.getToDate();
        String phone = requestData.getPhone();

        ResponsePage<List<UserDTO>> response = userService.getUsers(userCode,fromDate,toDate,phone,pageable);

        return ResponseEntity.ok(response);

    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Response<UserDTO>> getUser(@PathVariable Long id) {
        Response<UserDTO> response = userService.getDetailUser(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user/update/{id}")
    public ResponseEntity<Response<UserDTO>> updateUser(
            @PathVariable Long id,
            @RequestBody UserDTO userDTO) {
        Response<UserDTO> response = userService.updateDetailUser(id, userDTO);
        return ResponseEntity.ok(response);
    }

}
