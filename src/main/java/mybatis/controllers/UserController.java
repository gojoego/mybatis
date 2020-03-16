package mybatis.controllers;

import mybatis.exceptions.NewUserException;
import mybatis.models.ResponseObject;
import mybatis.models.Task;
import mybatis.models.User;
import mybatis.services.UserService;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// accepts incoming connections
// calls service

@RestController
// designates to accept incoming requests
@RequestMapping("/users")
// 8080
public class UserController<Tasks> {

    @Autowired
    UserService userService;
    // injects bean of type UserService into this class called userService


    @GetMapping
    public ArrayList<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User insertUser(@RequestBody User user) throws NewUserException {
        return userService.insertUser(user);
    }

    @PatchMapping
    public User patchUser(@RequestBody User user) throws NewUserException {
        return userService.patchUser(user);
    }

    // localhost:8080/users/id1/id2?id3=some_id
    @RequestMapping("/{id}") // path variables
    public User findById(@PathVariable(value = "id") int id) {
        return userService.findById(id);

    }

    @DeleteMapping
    public User deleteById(@RequestParam(value = "id") int id) throws NewUserException {
        // this is saying I'll pass you an ID in postman
        // http://localhost:8080/users?id=13

        return userService.deleteUser(id);
    }
    // controller speaking to website

    @GetMapping("/sayHi")
    public String sayHi() {
        return "hi";
    }

    @GetMapping("/{user_id}/tasks")
    public ResponseObject<ArrayList<Task>>
    findIncompleteTasksByUserId(@PathVariable("user_id") int user_id,
                                @RequestParam(value = "complete", defaultValue = "-1")
                                        String complete) {
        ResponseObject<ArrayList<Task>> retVal = new ResponseObject<>();
        ArrayList<Task> obj = userService.findTasksByUserId(user_id, complete);
        retVal.setData(obj);
        retVal.setResponse_code(200);
        retVal.setMessage("here's the tasks associated with this ID");
        return retVal;
    }
}


