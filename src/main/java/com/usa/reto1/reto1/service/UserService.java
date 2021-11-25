package com.usa.reto1.reto1.service;

import com.usa.reto1.reto1.model.User;
import com.usa.reto1.reto1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }
    public User toRegister(User user){
        if (user.getId() == null){
            if (userRepository.existsEmail(user.getEmail()) == false){
                return userRepository.save(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    public boolean existsEmail(String email){
        return userRepository.existsEmail(email);
    }

    public User authenticateUser(String email, String password){
        Optional<User> user = userRepository.authenticateUser(email, password);
        if (user.isEmpty()){
            return new User(email, password, "NO DEFINIDO");
        }else {
            return user.get();
        }
    }
}