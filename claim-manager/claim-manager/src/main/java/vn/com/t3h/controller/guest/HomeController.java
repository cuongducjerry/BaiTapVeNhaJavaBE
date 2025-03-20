package vn.com.t3h.controller.guest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class HomeController {

    @GetMapping(value={"/", "/home"})
    public String homePage(){
        return "guest/home-page";
    }

    @GetMapping(value= "/dashboard")
    public String getDashBoard(){
        return "cms/dashboard";
    }

    @GetMapping(value= "/claim-manager")
    public String getClaimManager(){
        return "cms/claim-manager";
    }

    @GetMapping(value= "/detail-claim")
    public String getDetailClaim(){
        return "cms/detail-claim";
    }

}
