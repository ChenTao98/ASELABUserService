package com.chentao.aselab.user.controller;

import com.chentao.aselab.user.controller.request.UserRequest;
import com.chentao.aselab.user.controller.response.ResponseObject;
import com.chentao.aselab.user.controller.response.UserResponse;
import com.chentao.aselab.user.entity.User;
import com.chentao.aselab.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private UserService userService;
    private static final String SUCCESS="success";
    private static final String API="/api/";

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping(API+"/user/register")
    public ResponseEntity<Object> register(@RequestBody UserRequest userRequest){
        ResponseObject responseObject=new ResponseObject();
        responseObject.setErrorCode(1);
        if(userRequest.isNull()){
            responseObject.setMessage("register info is incomplete");
            return ResponseEntity.ok(responseObject);
        }
        String messageStr= userService.register(userRequest);
        if(messageStr.equals(SUCCESS)){
            responseObject.setErrorCode(0);
            responseObject.setMessage(SUCCESS);
            responseObject.setData(new UserResponse(userService.getUserByUsername(userRequest.getUsername())));
        }else {
            responseObject.setMessage(messageStr);
        }
        return ResponseEntity.ok(responseObject);
    }
    @PostMapping(API+"/user/login")
    public ResponseEntity<Object> login(@RequestBody UserRequest userRequest){
        User user=userService.login(userRequest);
        ResponseObject responseObject=new ResponseObject();
        if(user==null){
            responseObject.setErrorCode(1);
            responseObject.setMessage("Username or password is wrong");
        }else {
            responseObject.setErrorCode(0);
            responseObject.setMessage("success");
            responseObject.setData(new UserResponse(user));
        }
        return ResponseEntity.ok(responseObject);
    }
    @GetMapping(API+"/user/profile")
    public ResponseEntity<Object> profile(@RequestParam Long userId){
        User user=userService.getUserById(userId);
        ResponseObject responseObject=new ResponseObject();
        if(user==null){
            responseObject.setErrorCode(1);
            responseObject.setMessage("User is not found");
        }else {
            responseObject.setErrorCode(0);
            responseObject.setMessage("success");
            responseObject.setData(new UserResponse(user));
        }
        return ResponseEntity.ok(responseObject);
    }
}
