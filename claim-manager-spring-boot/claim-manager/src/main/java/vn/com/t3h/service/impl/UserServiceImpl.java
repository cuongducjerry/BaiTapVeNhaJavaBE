package vn.com.t3h.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.com.t3h.entity.ClaimEntity;
import vn.com.t3h.entity.RoleEntity;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.mapper.UserMapper;
import vn.com.t3h.repository.RoleRepository;
import vn.com.t3h.repository.UserRepository;
import vn.com.t3h.service.UserService;
import vn.com.t3h.service.dto.ClaimDTO;
import vn.com.t3h.service.dto.UserDTO;
import vn.com.t3h.service.dto.response.Response;
import vn.com.t3h.service.dto.response.ResponsePage;
import vn.com.t3h.utils.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Value("${application.root.folder}")
    private String rootFolderUpload;

    @Value("${application.root.folder.image}")
    private String rootFolderImageUpload;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Response<UserDTO> saveUser(UserDTO userDto) {
        //      3.	Lưu lại đường dẫn của ảnh
        String pathFileAvatar = saveImageAvatar(userDto);

        // 4.	Convert toàn bộ dữ liệu dạng userDto sang dạng UserEntity để lưu vào database
        UserEntity userEntity = userMapper.toEntity(userDto);
        userEntity.setPathAvatar(pathFileAvatar);
        // set role
        setRole(userEntity);
        // save vao db
        userEntity = userRepository.save(userEntity);
        // Convert về dạng userDto
        userDto = userMapper.toDto(userEntity);
        Response<UserDTO> response = new Response<UserDTO>();
        response.setCode(HttpStatus.OK.value());
        response.setMessage(HttpStatus.OK.name());
        response.setData(userDto);
        return response;
    }

    @Override
    public ResponsePage<List<UserDTO>> getUsers(
            String claimCode,
            LocalDate fromDate,
            LocalDate toDate,
            String phone,
            Pageable pageable) {
        if (StringUtils.isEmpty(claimCode)){
            claimCode = null;
        }
        if (StringUtils.isEmpty(phone)){
            phone = null;
        }
        Page<UserEntity> pageEntity = userRepository.findCondition(claimCode,fromDate,toDate,phone,pageable);
        // convert data entity -> dto
        List<UserDTO> userDTOs = new ArrayList<UserDTO>();

        userDTOs = pageEntity.map(entity -> userMapper.toDto(entity)).stream().toList();
        ResponsePage<List<UserDTO>> response = new ResponsePage<>();
        response.setData(userDTOs);
        response.setMessage("Success");
        response.setCode(HttpStatus.OK.value()); // 200
        response.setTotalElement(pageEntity.getTotalElements());
        response.setTotalPage(pageEntity.getTotalPages());
        response.setPageSize(pageable.getPageSize());
        response.setPageIndex(pageable.getPageNumber());
        return response;
    }

    private void setRole(UserEntity userEntity) {
        RoleEntity roleEntity = roleRepository.findByCodeAndDeletedIsFalse(Constant.ROLE_ADMIN_CODE);
        Set<RoleEntity> roleEntities = new HashSet<>();
        roleEntities.add(roleEntity);
        userEntity.setRoles(roleEntities);
    }

    public String saveImageAvatar(UserDTO userDTO){

        if (StringUtils.isEmpty(userDTO.getStringBase64Avatar())){
            return "";
        }
        String[] partsBase64 = userDTO.getStringBase64Avatar().split(",");
        // get mime type image
        String mimeType = partsBase64[0];
        // lấy phần dữ liệu image base64
        String dataImage = partsBase64[1];
        byte[] decodedByte = Base64.getDecoder().decode(dataImage);
        // xác định đuôi của file
        String fileExtension = "";
        if (mimeType.contains("image/jpeg")){
            fileExtension = ".jpg";
        }else if (mimeType.contains("image/png")){
            fileExtension = ".png";
        }

        //      2.	lưu file image vào folder của ổ cứng local tại path D:\T3h\LJava2411\github\LJava2411\LJava2411\spring-boot\file-upload\image
        // lưu file image vào folder ổ cứng
//        String rootFolderImage = "D:\\T3h\\LJava2411\\github\\LJava2411\\LJava2411\\spring-boot\\file-upload\\image\\";
        String rootFolderImage =  rootFolderUpload + rootFolderImageUpload;
        String fileName = "avatar_" + userDTO.getUsername() + fileExtension;
        String finalPathAvatar = rootFolderImage + fileName;

        // Kiểm tra xem có thư mục đó chưa
        File rootFolderData = new File(rootFolderImage);
        if (!rootFolderData.exists()){ // nếu chưa có -> tạo folder
            rootFolderData.mkdir();
        }

        // lưu file
        try (FileOutputStream fos = new FileOutputStream(new File(finalPathAvatar))){
            fos.write(decodedByte);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            System.out.println("Save file success " + finalPathAvatar);
        }
        return finalPathAvatar;
    }

}
