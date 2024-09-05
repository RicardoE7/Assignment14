package com.coderscampus.assignment14.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.coderscampus.assignment14.domain.User;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();
    private static Long idCounter = 0L;

    public User saveUser(User user) {
        user.setUserId(generateId());
        users.add(user);
        return user;
    }

    public List<User> findAllUsers() {
        return new ArrayList<>(users);
    }

    private synchronized Long generateId() {
        return ++idCounter;
    }
}