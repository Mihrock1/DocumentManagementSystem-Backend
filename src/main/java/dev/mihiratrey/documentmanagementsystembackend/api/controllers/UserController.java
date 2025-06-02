package dev.mihiratrey.documentmanagementsystembackend.api.controllers;


import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.CreateUserInput;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.CreateUserOutput;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.createUser.ICreateUser;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.fetchUsers.FetchUsersOutput;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.fetchUsers.IFetchUsers;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private final ICreateUser createUserService;
    
    private final IFetchUsers fetchUsersService;

    public UserController(ICreateUser createUserService, IFetchUsers fetchUsersService) {
        this.createUserService = createUserService;
        this.fetchUsersService = fetchUsersService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateUserOutput> createUser(@RequestBody CreateUserInput request) {
        
        CreateUserOutput createUserOutput = createUserService.Execute(request);
        URI location = URI.create("/api/user/" + createUserOutput.getUserId());
        
        return ResponseEntity.created(location).body(createUserOutput);
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping()
    @PreAuthorize("hasRoles('ADMIN', 'NORMAL')")
    public ResponseEntity<FetchUsersOutput> fetchUserByEmail(Authentication auth) {
        String email = auth.getName();
        
        FetchUsersOutput fetchUsersOutput = fetchUsersService.fetchSingleUserByEmail(email);
//        URI location = URI.create("/api/user/" + fetchUsersOutput.getUserId());
        
        return ResponseEntity.ok(fetchUsersOutput);
    }
}
