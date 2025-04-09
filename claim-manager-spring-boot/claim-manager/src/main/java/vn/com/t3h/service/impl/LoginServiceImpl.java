package vn.com.t3h.service.impl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import vn.com.t3h.entity.UserEntity;
import vn.com.t3h.repository.UserRepository;
import vn.com.t3h.service.LoginService;
import vn.com.t3h.service.dto.FileService;
import vn.com.t3h.utils.Constant;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FileService fileService;

    @Override
    public String processAfterLoginSuccess(HttpServletRequest request){
        // lấy ra thông tin user hiện tại đang thực hiện request vừa login xong
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // neu authen == null hoac chua login
        if(authentication == null || !authentication.isAuthenticated()){
            throw new AuthenticationServiceException("Authentication required");
        }
        // thông tin user hiện tại
        UserDetails userDetails =  (UserDetails)authentication.getPrincipal();
        System.out.println(String.format("User %s logged in", userDetails.getUsername()));
        String username = userDetails.getUsername();
        UserEntity user = userRepository.findByUsername(username);
        HttpSession session = request.getSession(false);
        if(user != null){
            session.setAttribute("username", user.getUsername());
            session.setAttribute("fullname", user.getFirstName() + " " + user.getLastName());
            session.setAttribute("role", user.getRoles());

            String fileBase64 = fileService.getBase64FromPath(user.getPathAvatar());
            String pathAvatar = user.getMimeType() + fileBase64;

            session.setAttribute("pathAvatar", pathAvatar);
            session.setAttribute("idUser", user.getId());
        }
        // lay ra danh sach quyen cua user
        List<String> roleCode = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        System.out.println(String.format("Role code: %s", roleCode));
        // kiểm tra xem có phải admin không
        boolean isAdmin = roleCode.contains(Constant.PREFIX_ROLE + Constant.ROLE_ADMIN_CODE);
        if(isAdmin){
            return "redirect:/cms/dashboard"; // role admin
        }
        return "redirect:/home"; // role user
    }

}
