package com.sparta.jian.libraryproject.services;

import com.sparta.jian.libraryproject.entities.UserEntity;
import com.sparta.jian.libraryproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

    public Integer findUserIdByName(String name){
        return userRepository.findUserIdByName(name);
    }

    public List<Object[]> getAllUsersByArray(){
        return userRepository.getAllUsersByArray();
    }

    public UserEntity findUserById(Integer id){
        return userRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("Invalid ID" + id)
        );
    }
}
