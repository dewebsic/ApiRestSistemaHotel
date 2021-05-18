package com.angelsepulveda.apirestsistemahotel.security.controllers;
;
import com.angelsepulveda.apirestsistemahotel.security.dtos.NewUserDto;
import com.angelsepulveda.apirestsistemahotel.security.dtos.UserLoginDto;
import com.angelsepulveda.apirestsistemahotel.security.services.contracts.AuthService;
import com.angelsepulveda.apirestsistemahotel.security.services.contracts.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    public AuthController(AuthService authService,UserService userService){
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody NewUserDto dto) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.save(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(this.authService.login(dto));
    }
}
