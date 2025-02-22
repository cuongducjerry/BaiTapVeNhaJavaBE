package vn.com.t3h.book.security;

import jakarta.servlet.http.HttpServletRequest;
import vn.com.t3h.book.dao.UserDao;
import vn.com.t3h.book.dao.impl.UserDaoImpl;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.service.UserService;
import vn.com.t3h.book.service.impl.UserServiceImpl;
import vn.com.t3h.book.util.Constants;
import vn.com.t3h.book.util.SessionUtil;

public class AuthenticationServiceImpl implements AuthenticationService {
    private UserService userService;
    private UserDao userDao = new UserDaoImpl();

    public AuthenticationServiceImpl() {
        userService = new UserServiceImpl(userDao);
    }
    @Override
    public String login(String username, String password, HttpServletRequest request) {
        UserModel userModel = userService.findUserByUserAndPassword(username, password);
        if (userModel == null) {
            return "/login?message=loginError";
        }
        request.getSession().setAttribute(SessionUtil.SESSION_ID_CURRENT_USER, userModel);
        String role = userModel.getRole();
        System.out.println(role);
        String urlRedirect = "";
        if (Constants.ROLE.ADMIN.name().equalsIgnoreCase(role)){
            urlRedirect = "/cms/books";
        }else if (Constants.ROLE.CUSTOMER.name().equalsIgnoreCase(role)){
            urlRedirect = "/home";
        }else if (Constants.ROLE.EMPLOYEE.name().equalsIgnoreCase(role)){
            urlRedirect = "/dms/books-employee";
        }
        return urlRedirect;
    }
}
