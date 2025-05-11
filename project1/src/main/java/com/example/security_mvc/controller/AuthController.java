package com.example.security_mvc.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // @PostMapping("/login")
    // public ResponseEntity<String> login(@RequestBody LoginRequest request) {
    // try {
    // // Tạo đối tượng Authentication từ thông tin đăng nhập
    // UsernamePasswordAuthenticationToken authToken =
    // new UsernamePasswordAuthenticationToken(request.username(),
    // request.password());

    // // Xác thực thông tin đăng nhập
    // Authentication authentication =
    // authenticationManager.authenticate(authToken);

    // // Lưu thông tin xác thực vào SecurityContext
    // SecurityContextHolder.getContext().setAuthentication(authentication);

    // return ResponseEntity.ok("Đăng nhập thành công cho người dùng: " +
    // authentication.getName());
    // } catch (AuthenticationException e) {
    // return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Đăng nhập thất
    // bại: " + e.getMessage());
    // }
    // }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request, HttpServletRequest httpRequest) {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.username(),
                    request.password());

            Authentication authentication = authenticationManager.authenticate(authToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Gắn SecurityContext vào session
            httpRequest.getSession().setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    SecurityContextHolder.getContext());

            return ResponseEntity.ok("Đăng nhập thành công cho người dùng: " + authentication.getName());
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Đăng nhập thất bại: " + e.getMessage());
        }
    }

    @GetMapping(path = { "/", "home" })
    public String getMethodName() {
        return "access accepted";
    }

}

record LoginRequest(String username, String password) {
}
