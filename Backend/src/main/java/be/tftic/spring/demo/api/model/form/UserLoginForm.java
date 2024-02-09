package be.tftic.spring.demo.api.model.form;

import be.tftic.spring.demo.domain.entities.User;
import lombok.Getter;

@Getter
public class UserLoginForm {

    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toEntity() {
        User user = new User();
        user.setEmail(this.email);
        user.setPassword(this.password);

        return user;
    }
}
