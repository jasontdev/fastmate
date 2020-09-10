package dev.jasont.fastmate.server.controller;

import dev.jasont.fastmate.server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/auth/register")
    public ResponseEntity<?> register(@RequestParam("username") String username,
                                      @RequestParam("password") String rawPassword) {

        if(authService.register(username, rawPassword))
            return ResponseEntity.ok().build();

        return ResponseEntity.status(409).build();
    }
}
