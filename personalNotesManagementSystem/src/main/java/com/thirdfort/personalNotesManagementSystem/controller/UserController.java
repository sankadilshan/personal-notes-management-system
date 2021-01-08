package com.thirdfort.personalNotesManagementSystem.controller;


import com.thirdfort.personalNotesManagementSystem.service.UserService;
import com.thirdfort.personalNotesManagementSystemModels.ModelDto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/health")
    public String health(){
        return  "up";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void register(@RequestBody UserDto user){
        userService.initiate(user);
    }
}
