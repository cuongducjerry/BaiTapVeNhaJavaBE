package vn.com.t3h.service.request;

import java.time.LocalDate;

public class RequestData {
    private String claimCode;
    private LocalDate fromDate;
    private LocalDate toDate;
    private String statusName;

    public RequestData(String claimCode, LocalDate fromDate, LocalDate toDate, String statusName) {
        this.claimCode = claimCode;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.statusName = statusName;
    }

    public String getClaimCode() {
        return claimCode;
    }

    public void setClaimCode(String claimCode) {
        this.claimCode = claimCode;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
