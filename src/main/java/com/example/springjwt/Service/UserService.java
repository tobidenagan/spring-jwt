package com.example.springjwt.Service;

import com.example.springjwt.domain.Role;
import com.example.springjwt.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void AddRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
