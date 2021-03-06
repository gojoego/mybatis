package mybatis.services;

import mybatis.exceptions.NewUserException;
import mybatis.mappers.TaskMapper;
import mybatis.mappers.UserMapper;
import mybatis.models.Task;
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

// field injection

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    //field injection using an object, can also use constructor or
    // object created using spring via mybatis

    @Autowired
    TaskMapper taskMapper;

    //  @Autowired
    //  User user;

    public ArrayList<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public User insertUser(User user) throws NewUserException {
        int i = userMapper.insertUser(user);

        if (i == 1) {
            return userMapper.findUserByFirstNameLastName(user.getFirst_name(), user.getLast_name());
            // comes from UserMapper
        } else {
            NewUserException ne = new NewUserException("error creating new user");
            throw ne;

        }

    }

    public User deleteUser(int id) throws NewUserException {

        int i = userMapper.makeUserInactive(id);
        // comes from the UserMapper

        if (i == 1) {
            userMapper.makeUserInactive(id);
            return userMapper.findById(id);
            // comes from userMapper
        } else {
            NewUserException ne = new NewUserException("could not find user");
            throw ne;

        }
    }

    public User patchUser(User user) throws NewUserException {
        int numberOfRows = userMapper.patchUser(user);

        if (numberOfRows == 1) {
            return userMapper.findById(user.getId());
        } else {
            NewUserException ne = new NewUserException("could not find user");
            throw ne;

        }

    }

    public User findById(int id) {
        return userMapper.findById(id);
    }

    public ArrayList<Task> findTasksByUserId(int user_id, String complete) {
        if (complete.equalsIgnoreCase("true")) {
            ArrayList<Task> obj = taskMapper.getAllCompleteTasksByUserID(user_id);
            return obj;
        } else if (complete.equalsIgnoreCase("false")){
            return taskMapper.getAllIncompleteTasksByUserID(user_id);
        } else {
            return taskMapper.findTasksByUserId(user_id);
        }


    }
    public Task selectTasksById(int user_id) {
            return userMapper.selectTasksById(user_id);

    }
}
