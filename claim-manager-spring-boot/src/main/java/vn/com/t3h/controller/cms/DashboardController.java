package vn.com.t3h.controller.cms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cms")
public class DashboardController {

    @GetMapping("/dashboard")
    public String getDashboard() {
        return "cms/dashboard";
    }

}
