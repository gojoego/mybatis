package mybatis.mappers;

// create this class file to separate from User class
// if we had a deliverables pojo would create a separate class
// focus of this class should be on making queries to database

import mybatis.models.Task;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
// imported when you use @Mapper annotation
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface TaskMapper {

    // put all queries up top
    // query: copy from mysql workbench
    // capital letters final
    String SELECT_ALL_TASKS = "SELECT * FROM `mybatis-test`.tasks";
    String CREATE_TASK = "INSERT INTO `mybatis-test`.tasks (task_name, " +
            "isComplete, user_id) VALUES (#{task_name}, #{isComplete}, #{user_id})";

    // @Select annotation requires query to run
    // can grab from above
    // functional equivalent could put query inside @select
    // cleaner to make variable
    // declare method here
    // when running query returns multiple entries
    // returns collection
    // want to use a collection or ArrayList of type object Task, import
    // abstract method so no method body needed
    // body will be created by mybatis
    // does all the boiler plate code
    // separation of responsibilities
    @Select(SELECT_ALL_TASKS)
    public ArrayList<Task> getAllTasks();

    @Insert(CREATE_TASK)
    public Task createUser();




}