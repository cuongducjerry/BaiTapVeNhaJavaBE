package vn.com.t3h.service;

import jakarta.servlet.http.HttpServletRequest;

public interface LoginService {
    public String processAfterLoginSuccess(HttpServletRequest req);
}
