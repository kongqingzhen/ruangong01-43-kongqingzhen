package kong.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import kong.entity.UsersEntity;
import kong.service.userService;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller("User_")
@Scope("prototype")
public class useraction extends ActionSupport {
    @Resource
    private userService userService;

    List<UsersEntity> users;

    private UsersEntity user;

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    public userService getUserService() {
        return userService;
    }

    public void setUserService(userService userService) {
        this.userService = userService;
    }



    public String edit()
    {
        System.out.println("213231232");
        System.out.println("yonghu"+user.getId());
        user=userService.getUserById(user.getId());
        System.out.println("213213213");
        return  "editUser";
    }

    public String rootlogin() {

        if(userService.login(user)) {
            Map session = ActionContext.getContext().getSession();
            session.put("user", user);
            return SUCCESS;
        } else {
            return ERROR;
        }


    }

    public String login() {

        if(userService.login(user)) {
            Map session = ActionContext.getContext().getSession();
            session.put("user", user);
            return SUCCESS;
        } else {
            return ERROR;
        }


    }

    public String getInfo()
    {
        user=userService.getUserByUsername(user.getName());
        return "get";
    }

    public String get()
    {
        user=userService.getUserByUsername(user.getName());
        return "recompensateAction";
    }
    public String list()
    {
        users=userService.list();
        return "listUser";
    }

    public  String add()
    {
        userService.addUser(user);
        return  "listUserAction";
    }

    public  String update()
    {
        userService.update(user);
        return "listUserAction";
    }

    public List<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UsersEntity> users) {
        this.users = users;
    }

}
