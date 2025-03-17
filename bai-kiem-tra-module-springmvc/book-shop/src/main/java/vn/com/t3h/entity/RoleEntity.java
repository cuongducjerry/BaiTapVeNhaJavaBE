package vn.com.t3h.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roleName;

    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users = new HashSet<>();

    public RoleEntity() {}

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                '}';
    }
}
