
package vn.com.t3h.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "claim_document")
public class ClaimDocumentEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "claim_id")
    private ClaimEntity claimEntity;

    private String documentType;
    private String documentName;
    private String filePath;
    private LocalDate uploadDate;

    public ClaimDocumentEntity() {

    }

    public ClaimEntity getClaimEntity() {
        return claimEntity;
    }

    public void setClaimEntity(ClaimEntity claimEntity) {
        this.claimEntity = claimEntity;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDate getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDate uploadDate) {
        this.uploadDate = uploadDate;
    }

    // Getters and Setters
}
