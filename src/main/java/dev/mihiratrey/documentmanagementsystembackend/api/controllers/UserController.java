package dev.mihiratrey.documentmanagementsystembackend.api.controllers;


import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.CreateUserInput;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.CreateUserOutput;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.ICreateUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final ICreateUser createUserService;

    public UserController(ICreateUser createUserService) {
        this.createUserService = createUserService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserOutput> createUser(@RequestBody CreateUserInput request) {
        
        CreateUserOutput output = createUserService.Execute(request);
        URI location = URI.create("/api/user/" + output.getUserId());
        
        return ResponseEntity.created(location).body(output);
    }
    
//    @GetMapping("/{userId}")
//    public ResponseEntity<>
}
