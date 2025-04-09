package vn.com.t3h.controller.cms.claim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cms")
public class ClaimController {

    @GetMapping(value= "/claim-manager")
    public String getPageClaimManager(){
        return "cms/claim/claim-manager";
    }

    @GetMapping(value= "/detail-claim")
    public String getPageDetailClaim(){
        return "cms/claim/detail-claim";
    }

}
