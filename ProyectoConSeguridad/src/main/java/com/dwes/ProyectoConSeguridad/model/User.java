package com.dwes.ProyectoConSeguridad.model;

import com.dwes.ProyectoConSeguridad.validation.UsernameTodoLetras;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UsernameTodoLetras
    @Column(unique = true, nullable = false)
    @NotBlank
    @Size(min = 4, max = 12)
    private String username;
    @Column(nullable = false)
    @NotBlank
    private String password;
    private boolean enabled;

    @Transient
    private boolean admin;

    @JsonIgnoreProperties({"users", "handler", "hibernateLazyInitializer"})
    @ManyToAny
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User(){
        this.roles = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
