package vn.com.t3h.model;

import vn.com.t3h.entity.RoleEntity;
import vn.com.t3h.entity.UserEntity;

import java.util.List;

public class UserDTO {
    private Long id;
    private String username;
    private String address;
    private String phone;
    private String email;
    private List<String> roles;
    private String identityNumber; // Thêm số CMND/CCCD

    // Constructor
    public UserDTO(UserEntity user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.roles = user.getRoles().stream()
                .map(RoleEntity::getRoleName)
                .toList();
        this.identityNumber = (user.getIdentityCard() != null) ? user.getIdentityCard().getIdentityNumber() : null;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<String> getRoles() { return roles; }
    public void setRoles(List<String> roles) { this.roles = roles; }

    public String getIdentityNumber() { return identityNumber; }
    public void setIdentityNumber(String identityNumber) { this.identityNumber = identityNumber; }
}
