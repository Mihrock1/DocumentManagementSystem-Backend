package dev.mihiratrey.documentmanagementsystembackend.infrastructure.useCasesImpl.fetchUsers;

import dev.mihiratrey.documentmanagementsystembackend.application.repositories.IUserRepository;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.fetchUsers.FetchUsersOutput;
import dev.mihiratrey.documentmanagementsystembackend.application.useCases.fetchUsers.IFetchUsers;
import dev.mihiratrey.documentmanagementsystembackend.domain.exceptions.UserNotFoundException;
import dev.mihiratrey.documentmanagementsystembackend.domain.models.User;
import dev.mihiratrey.documentmanagementsystembackend.infrastructure.mappers.UserEntityMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FetchUsers implements IFetchUsers {
    private final IUserRepository userRepository;

    public FetchUsers(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public FetchUsersOutput fetchSingleUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        
        if(optionalUser == null) {
            throw new UserNotFoundException(email);
        }
        
        User user = optionalUser.get();
        
        return new FetchUsersOutput(user.getUserId(), user.getEmail(), user.getName(), user.getContactNo(), user.getRole());
    }

    @Override
    public List<FetchUsersOutput> fetchAllUsers() {
        
        List<User> allUsers = userRepository.findAllUsers();
        
        List<FetchUsersOutput> allUsersOutput = allUsers.stream().map(user -> 
            new FetchUsersOutput(user.getUserId(), user.getEmail(), user.getName(), user.getContactNo(), user.getRole())
        ).toList();
        
        return allUsersOutput;
    }
}
