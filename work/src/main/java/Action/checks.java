package Action;

import kong.dao.DBConn_CD;
import com.opensymphony.xwork2.ActionSupport;

import java.sql.Connection;
import java.sql.Statement;

public class checks extends ActionSupport {
    private String username;
    private String pass;
    private String type;
    private String birthday;
    private String sex;
    private Connection conn;
    private Statement stat;

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStat() {
        return stat;
    }

    public void setStat(Statement stat) {
        this.stat = stat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    @Override
    public void validate() {
        if (getUsername() == null || getUsername().length()==0 ) {
            addFieldError("username", "用户名不能为空");
        }
        if (getPass() == null || getPass().length()==0 ) {
            addFieldError("pass", "密码不能为空");
        }
        if (getType() == null || getType().length()==0 ) {
            addFieldError("type", "用户类型不能为空");
        }
        if (getBirthday() == null || getBirthday().length()==0 ) {
            addFieldError("name", "生日不能为空");
        }
        if (getSex() == null || getSex().length()==0 ) {
            addFieldError("sex", "性别不能为空");
        }
    }

    public String execute() throws Exception {
        System.out.println(username);
        System.out.println("-----");
        System.out.println(this.username);
        conn = DBConn_CD.getConnection();
        String sql = "insert into users (name,password,type,birthday,sex) values('" + username + "','" + pass + "','" + type + "','" + birthday + "','" + sex + "')";
        System.out.println(sql);
        stat = conn.createStatement();
        int k=stat.executeUpdate(sql);
        if (k==0){
            return "error";
        }else
            return "success";


    }
}
