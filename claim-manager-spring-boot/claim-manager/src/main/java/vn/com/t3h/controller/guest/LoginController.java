package vn.com.t3h.controller.guest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.t3h.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "guest/login";
    }

    @GetMapping("/process-after-login-success")
    public String processAfterLoginSuccess(HttpServletRequest request) {
        return loginService.processAfterLoginSuccess(request);
    }

}
