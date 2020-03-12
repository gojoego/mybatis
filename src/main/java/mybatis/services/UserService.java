package mybatis.services;

import mybatis.mappers.UserMapper;
import mybatis.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// create bean out of class and user where necessary
// auto wire in mapper
    // @Autowired dependency injection
    // spring injects dependency where needed
// meat of logic
// reusable methods


@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public ArrayList<User> getAllUsers(){
        return userMapper.getAllUsers();
    }

}
