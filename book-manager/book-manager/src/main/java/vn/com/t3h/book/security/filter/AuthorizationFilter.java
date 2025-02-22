package vn.com.t3h.book.security.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.com.t3h.book.dao.UserDao;
import vn.com.t3h.book.dao.impl.UserDaoImpl;
import vn.com.t3h.book.model.UserModel;
import vn.com.t3h.book.service.UserService;
import vn.com.t3h.book.service.impl.UserServiceImpl;
import vn.com.t3h.book.util.Constants;
import vn.com.t3h.book.util.SessionUtil;

import java.io.IOException;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    private UserService userService;
    private UserDao userDao = new UserDaoImpl();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        userService = new UserServiceImpl(userDao);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserModel currentUser = (UserModel) request.getSession().getAttribute(SessionUtil.SESSION_ID_CURRENT_USER);

        String uri = request.getRequestURI();
        if (uri.startsWith("/cms")){
            if (currentUser != null){
                UserModel userModel = userService.findUserById(currentUser.getId());
                if (userModel != null && userModel.getRole().equalsIgnoreCase(Constants.ROLE.ADMIN.name())){
                    filterChain.doFilter(request, response);
                }else {
                    response.sendRedirect("/login?message="+ Constants.PERMISSION_DENIED);
                }
            }else {
                response.sendRedirect("/login?message="+Constants.DONT_LOGIN);
            }
        }else if(uri.startsWith("/dms")){
            if (currentUser != null){
                UserModel userModel = userService.findUserById(currentUser.getId());
                if (userModel != null && userModel.getRole().equalsIgnoreCase(Constants.ROLE.EMPLOYEE.name())){
                    filterChain.doFilter(request, response);
                }else {
                    response.sendRedirect("/login?message="+ Constants.PERMISSION_DENIED);
                }
            }else {
                response.sendRedirect("/login?message="+Constants.DONT_LOGIN);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
