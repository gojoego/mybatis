package mybatis.models;

// POJO
// instance variables must match database fields

public class Task {

    int id;
    String task_name;
    boolean isComplete;
    int user_id;

    // good practice to create one fully qualified constructor
    // which is a constructor that includes all of the instance variables
    // and a plain constructor


    public Task() {
    }

    public Task(int id, String task_name, boolean isComplete, int user_id) {
        this.id = id;
        this.task_name = task_name;
        this.isComplete = isComplete;
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

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task_name='" + task_name + '\'' +
                ", isComplete=" + isComplete +
                ", user_id=" + user_id +
                '}';
    }
}
