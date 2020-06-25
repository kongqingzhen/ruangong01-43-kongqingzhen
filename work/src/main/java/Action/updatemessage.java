package Action;

import kong.dao.DBConn_CD;
import kong.entity.UsersEntity;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class updatemessage extends ActionSupport implements SessionAware {
    private UsersEntity user;
    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }


    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public PreparedStatement getPstmt() {
        return pstmt;
    }

    public void setPstmt(PreparedStatement pstmt) {
        this.pstmt = pstmt;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private Map<String,Object> session;
    private ArrayList<UsersEntity> userArrayList = new ArrayList<UsersEntity>();

    private String username;

    public ArrayList<UsersEntity> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<UsersEntity> userArrayList) {
        this.userArrayList = userArrayList;
    }

    private String password;
    @Override
    public String execute() throws Exception {
        String sql="update users set password='"+password+"' where name ='"+username+"'";
        System.out.println(sql);
        conn= DBConn_CD.getConnection();
        stmt=conn.createStatement();
        stmt.executeUpdate(sql);
        return "success_user";
    }
}
