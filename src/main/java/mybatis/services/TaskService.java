package mybatis.services;

// after creating a mapper, we create this service class that contains all the logic ("real meat")

import mybatis.mappers.TaskMapper;
import mybatis.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
@Service
// tells spring that this class can be managed by spring as spring bean
// creates bean of this class to inject where needed
// so that spring can inject into the task controller
public class TaskService {

    // use spring dependency injector @autowired bc we're using mybatis
    // no point in using mybatis if not using autowired
    // autowire taskmapper into task service
    // field injection
    // could also create constuctor and add @autowire
    // or setter injection

    @Autowired
    TaskMapper taskMapper;
    // mybatis implements method, spring makes bean and inject into service

    // creating method arraylist of type task
    // designate
    // should have separation of responsibilites
    public ArrayList<Task> getAllTasks(){
        return taskMapper.getAllTasks();
    }

    public int deleteById(int id){
        return taskMapper.deleteById(id);
    }

    public Task getTaskById(int id) {
        return taskMapper.getTaskByI(id);
    }

    public int updateById(int id){return taskMapper.updateTaskById(id);}
}
