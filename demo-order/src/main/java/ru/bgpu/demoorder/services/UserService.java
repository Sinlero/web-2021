package ru.bgpu.demoorder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bgpu.demoorder.models.User;
import ru.bgpu.demoorder.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User getByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }

    public List<User> list() {
        ArrayList<User> list = new ArrayList<>();
        userRepository.findAll().forEach(u -> list.add(u));
        return list;
    }
}
