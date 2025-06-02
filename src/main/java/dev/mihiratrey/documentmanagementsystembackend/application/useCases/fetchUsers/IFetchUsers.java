package dev.mihiratrey.documentmanagementsystembackend.application.useCases.fetchUsers;

import java.util.List;

public interface IFetchUsers {
    FetchUsersOutput fetchSingleUserByEmail(String email);

    List<FetchUsersOutput> fetchAllUsers();
}
