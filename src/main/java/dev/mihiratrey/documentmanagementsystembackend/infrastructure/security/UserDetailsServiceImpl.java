package dev.mihiratrey.documentmanagementsystembackend.infrastructure.security;

import dev.mihiratrey.documentmanagementsystembackend.application.repositories.IUserRepository;
import dev.mihiratrey.documentmanagementsystembackend.domain.exceptions.UserNotFoundException;
import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final IUserRepository userRepository;

    public UserDetailsServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException(username)); 
        
        return new UserDetailsAdapter(user);
    }
}
