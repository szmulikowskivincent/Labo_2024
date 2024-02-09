package be.tftic.spring.demo.api.model.dto;

public record UserTokenDTO(
        UserDTO user,
        String token
) {
}
