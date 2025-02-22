package vn.com.t3h.book.security;

import jakarta.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    public String login(String username, String password, HttpServletRequest request);

}
