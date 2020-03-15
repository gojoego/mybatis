package mybatis.controllers;

// task controller should focus on accepting incoming connections
// add exception handling


import mybatis.exceptions.NewUserException;
import mybatis.models.ResponseObject;
import mybatis.models.Task;
import mybatis.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseObject<ArrayList<Task>> getAllTasks() {
        ResponseObject<ArrayList<Task>> retVal = new ResponseObject<>();
        retVal.setData(taskService.getAllTasks());
        retVal.setResponse_code(200);
        retVal.setMessage("here's the tasks");
        return retVal;
    }

    @GetMapping("/{id}")
    public ResponseObject<Task> getTaskById(@PathVariable("id") int id) {
        ResponseObject<Task> retVal = new ResponseObject<>();
        retVal.setData(taskService.getTaskById(id));
        retVal.setResponse_code(200);
        retVal.setMessage("here's the tasks");
        return retVal;
    }

    // will return all tasks
    // could add additional mapping like "/all " but not necessary

    // when deleting will return
    @DeleteMapping("/{id}")
    public ResponseObject deleteById(@PathVariable("id") int id) {
        int status = taskService.deleteById(id);
        ResponseObject<String> retVal = new ResponseObject<>();

        if (status == 1) {
            retVal.setMessage("task successfully deleted");
            retVal.setResponse_code(200);
        } else if (status == 0) {

            retVal.setMessage("no task to delete");
            retVal.setResponse_code(200);
        }else{
            retVal.setMessage("more than one task deleted");
            retVal.setResponse_code(200);
        } return retVal;
    }
    @PatchMapping
    public int updateTaskById(@RequestBody int id) throws NewUserException {
        return taskService.updateById(id);
    }

}
