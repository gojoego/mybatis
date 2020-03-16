package mybatis.models;

// POJO
// instance variables must match database fields


public class Task {

    int id;
    String task_name;
    boolean is_complete;
    int user_id;

    // good practice to create one fully qualified constructor
    // which is a constructor that includes all of the instance variables
    // and a plain constructor


    public Task() {
    }

    public Task(int id, String task_name, boolean is_complete, int user_id) {
        this.id = id;
        this.task_name = task_name;
        this.is_complete = is_complete;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public boolean isIs_complete() {
        return is_complete;
    }

    public void setIs_complete(boolean is_complete) {
        this.is_complete = is_complete;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
