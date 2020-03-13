package mybatis.controllers;

// task controller should focus on accepting incoming connections

import mybatis.models.Task;
import mybatis.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
// accepts incoming connections over HTTP
// annotate with this to designate controller
@RequestMapping("/tasks")
// any url with /tasks will come to this class
public class TaskController {

    // must be autowired because taskmapper also autowired
    // dependency injection is all or nothing
    @Autowired
    TaskService taskService;


    @GetMapping
    public ArrayList<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    // will return all tasks
    // could add additional mapping like "/all " but not necessary


    public int deleteById(int id){
        return id;
    }

}
