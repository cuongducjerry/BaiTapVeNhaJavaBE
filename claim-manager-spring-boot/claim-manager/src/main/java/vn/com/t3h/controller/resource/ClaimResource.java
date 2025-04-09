package vn.com.t3h.controller.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.t3h.service.ClaimService;
import vn.com.t3h.service.dto.ClaimDTO;
import vn.com.t3h.service.dto.response.ResponsePage;
import vn.com.t3h.service.request.RequestDataClaim;

import java.time.LocalDate;
import java.util.List;

/**
 Đánh dấu đây là 1 controller trả về dữ liệu dạng json cho api
 */
@RestController
@RequestMapping("/api/claim")
public class ClaimResource {

    @Autowired
    private ClaimService claimService;
    // localhost:8080/api/claim?page=0&size=4&claimCode=C001&fromDate=2024-04-28
    @GetMapping()
    public ResponseEntity<ResponsePage<List<ClaimDTO>>> getListClaim(
            @RequestParam(required = false) String claimCode, // required = false: có thể truyền vào param hoặc không truyền vào
            @RequestParam(required = false) LocalDate fromDate,
            @RequestParam(required = false) LocalDate toDate,
            @RequestParam(required = false) String codeStatus,
            Pageable pageable){
        ResponsePage<List<ClaimDTO>> response = claimService.getClaims(claimCode,fromDate,toDate,codeStatus,pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClaimDTO> getClaimByCode(@PathVariable("id") long id){
        ClaimDTO claimDTO = claimService.findById(id);
        return ResponseEntity.ok(claimDTO);
    }

    @PostMapping()
    public ResponseEntity<ResponsePage<List<ClaimDTO>>> getPostClaimsTarget(
            @RequestBody RequestDataClaim requestData,
            Pageable pageable) {

        String claimCode = requestData.getClaimCode();
        LocalDate fromDate = requestData.getFromDate();
        LocalDate toDate = requestData.getToDate();
        String statusName = requestData.getStatusName();

        ResponsePage<List<ClaimDTO>> response = claimService.getClaims(claimCode,fromDate,toDate,statusName,pageable);

        return ResponseEntity.ok(response);

    }

}