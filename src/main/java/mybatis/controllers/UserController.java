package mybatis.controllers;

import mybatis.models.User;
import mybatis.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// accepts incoming connections
// calls service

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;
    // injects bean of type UserService into this class called userService

    @GetMapping
    public ArrayList<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
