package mybatis.mappers;

import mybatis.models.Task;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import mybatis.models.User;

@Mapper
// comes from ibatis
public interface UserMapper {


    //queries
    String SELECT_ALL_USERS = "select * from `mybatis-test`.users";

    String SELECT_BY_FIRST_LAST_NAME = "select * from `mybatis-test`.users " +
            "where first_name = #{param1} and last_name = #{param2}";

    String INSERT_USER = "INSERT INTO `mybatis-test`.users (first_name, last_name) " +
            "VALUES (#{first_name}, #{last_name})";

    String DELETE_USER = "UPDATE `mybatis-test`.users set isActive = false where id = #{id} ";

    String UPDATE_USER = "UPDATE `mybatis-test`.`users` SET `first_name` = #{first_name}, " +
            "`last_name` = #{last_name}, `isActive` = #{isActive} WHERE (`id` = #{id})";

    String SELECT_BY_ID = "SELECT * from `mybatis-test`.users where id =#{id}";

    String SELECT_TASKS_BY_ID = "SELECT * from 'mybatis.test'.tasks where user_id = #{user_id}";


    // bring queries to annotations and mybatis does the rest of the work
    // will also put them into array list as well
    @Select(SELECT_ALL_USERS)
    public ArrayList<User> getAllUsers();

    @Insert(INSERT_USER)
    public int insertUser(User user);


    @Select(SELECT_BY_FIRST_LAST_NAME)
    User findUserByFirstNameLastName(String first_name, String last_name);

    @Update(DELETE_USER)
    int makeUserInactive(int id);
    // have to be int because they return the number of rows affected

    @Update(UPDATE_USER)
    int patchUser(User user);
    // have to be int because they return the number of rows affected

    @Select(SELECT_BY_ID)
    User findById(int id);

    @Select(SELECT_TASKS_BY_ID)
    Task selectTasksById(int user_id);




}
