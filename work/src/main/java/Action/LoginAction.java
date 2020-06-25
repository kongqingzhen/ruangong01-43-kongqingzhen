package Action;

import kong.dao.DBConn_CD;
import kong.entity.UsersEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {
    private UsersEntity user;//模型驱动
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private Map<String,Object> session;

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
//        String sql="select * from User";
        String sql="select * from users where name=? and password=?";
        conn= DBConn_CD.getConnection();
        System.out.println("conn ok");
        pstmt=conn.prepareStatement(sql);
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getPassword());
        rs=pstmt.executeQuery();
        ActionContext ac= ActionContext.getContext();
        session=ac.getSession();
        while (rs.next()){
            System.out.println("rs="+rs.getString(1));
//            session.put("username",this.username);
            session.put("username", user.getName());
            session.put("type", rs.getString("type"));
            if (session.get("type").equals("管理员"))
                return "success_root";
            else
                return "success_user";
//            return super.execute();
        }
        return "Login";

    }

    public static void main(String[] args) throws Exception {
        new LoginAction().execute();
    }
}
