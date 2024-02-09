package be.tftic.spring.demo.api.model.dto;

import be.tftic.spring.demo.domain.entities.User;
import be.tftic.spring.demo.domain.enums.UserRole;
import lombok.Getter;

@Getter
public class UserDTO {

    private Long id;
    private String email;
    private String password;
    private UserRole role;

    public UserDTO() {

    }

    public UserDTO(Long id, String email, String password, UserRole role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Méthode de conversion de l'entité User vers UserDTO
    public static UserDTO fromEntity(User u) {
        return new UserDTO(u.getId(), u.getEmail(), u.getPassword(), u.getRole());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

