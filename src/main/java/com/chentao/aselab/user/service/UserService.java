package com.chentao.aselab.user.service;

import com.chentao.aselab.user.controller.request.UserRequest;
import com.chentao.aselab.user.entity.User;
import com.chentao.aselab.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private static final String USERNAME_IS_EXIST="User name have been used";
    private static final String EMAIL_IS_EXIST="Email have been used";
    private static final String SUCCESS="success";
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User getUserById(Long id){
        return userRepository.findUserById(id);
    }
    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }
    public String register(UserRequest userRequest){
        if(userRepository.findUserByUsername(userRequest.getUsername())!=null){
            return USERNAME_IS_EXIST;
        }
        if(userRepository.findUserByEmail(userRequest.getEmail())!=null){
            return EMAIL_IS_EXIST;
        }
        User user=new User(userRequest);
        userRepository.save(user);
        return SUCCESS;
    }
    public User login(UserRequest userRequest){
        User user=new User(userRequest);
        user=userRepository.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
        return user;
    }
}
