package be.tftic.spring.demo.api.controllers;

import be.tftic.spring.demo.api.model.dto.UserDTO;
import be.tftic.spring.demo.api.model.dto.UserTokenDTO;
import be.tftic.spring.demo.api.model.form.UserLoginForm;
import be.tftic.spring.demo.api.utils.JwtUtils;
import be.tftic.spring.demo.bll.services.AuthenticationService;
import be.tftic.spring.demo.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtUtils jwtUtils;

    @PostMapping("/api/register")
    public ResponseEntity<UserTokenDTO> register(@RequestBody UserLoginForm loginForm) {
        User u = authenticationService.register(loginForm.toEntity());
        if (u == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        UserDTO dto = UserDTO.fromEntity(u);
        return ResponseEntity.ok(new UserTokenDTO(dto, jwtUtils.generateToken(u)));
    }

    @PostMapping("/api/login")
    public ResponseEntity<UserTokenDTO> login(@RequestBody UserLoginForm loginForm) {
        User u = authenticationService.login(loginForm.toEntity());
        if (u == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        UserDTO dto = UserDTO.fromEntity(u);
        return ResponseEntity.ok(new UserTokenDTO(dto, jwtUtils.generateToken(u)));
    }
}

