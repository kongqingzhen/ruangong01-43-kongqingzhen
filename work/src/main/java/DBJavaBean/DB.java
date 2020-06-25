package DBJavaBean;

import org.apache.struts2.interceptor.ServletRequestAware;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

//import JavaBean.UserNameBean;

//实现ServletRequestAware 通过IoC方式直接访问Servlet，并通过 request获取 session对象
public class DB implements ServletRequestAware {
    private String driverName = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/players?&useSSL=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "123456";
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    private HttpServletRequest request;
    private Map<String,Object> session_falg;

    public Map<String, Object> getSession_falg() {
        return session_falg;
    }

    public void setSession_falg(Map<String, Object> session_falg) {
        this.session_falg = session_falg;
    }

    public DB() {
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setServletRequest(HttpServletRequest hsr) {
        request = hsr;
    }

    //完成连接数据库操作，并生成容器返回
    public Statement getStatement() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/players?&useSSL=false&serverTimezone=UTC";
            Connection con = DriverManager.getConnection(url, "root", "123456");
            return con.createStatement();
            /*Class.forName(getDriverName());
            con=DriverManager.getConnection(getUrl(), getUser(), getPassword());
            return con.createStatement();*/
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    //查询登录名，密码是否存在
    public ResultSet selectLogin(HttpServletRequest request, String userName, String password) {
        try {
            String sql = "select * from user where username='" + userName + "' and password='" + password + "'";
            st = getStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //返回登录用户的用户名
  /*  public String returnLogin(HttpServletRequest request) {
        String LoginName = null;
        HttpSession session = request.getSession();
        ArrayList login = (ArrayList) session.getAttribute("userName");
        *//*String flag=(String)session_falg.get("username");
        System.out.println(flag);*//*
        if (login == null || login.size() == 0) {
            LoginName = null;
        } else {
            for (int i = login.size() - 1; i >= 0; i--) {
                UserNameBean nm = (UserNameBean) login.get(i);
                LoginName = nm.getUserName();
            }

        }
        return LoginName;
    }*/

//    调用myLogin、myMessage、myFriends、myDayTime、myFile方法，把所有的和用户有关的信息全部保存到session对象中,该方法，登录成功后调用
/*    public String addList(HttpServletRequest request, String userName) {
        String sure = null;
         String login = myLogin(request, userName);
*//*       String mess = myMessage(request, userName);
        String fri = myFriends(request, userName);
        String day = myDayTime(request, userName);*//*
        String file = myFile(request, userName);
        if ( file.equals("ok")) {
            sure = "ok";
        } else {
            sure = null;
        }
        return sure;
    }*/

    //修改用户密码
/*    public String updatePass(HttpServletRequest request, String userName, String password) {
        try {
            String sure = null;
            String sql = "update myuser set password='" + password + "' where userName='" + userName + "'";
            st = getStatement();
            int row = st.executeUpdate(sql);
            if (row == 1) {
                String mess = myLogin(request, userName);
                if (mess.equals("ok")) {
                    sure = "ok";
                } else {
                    sure = null;
                }
            } else {
                sure = null;
            }
            return sure;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/



    //查询个人信息，并返回 rs
    public ResultSet selectMess(HttpServletRequest request, String userName) {
        try {
            String sql = "select * from user where name='" + userName + "'";
            st = getStatement();
            return st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //把登录人的信息保存到session对象中
    /*public String myLogin(HttpServletRequest request, String userName) {
        try {
            ArrayList listName = null;
            HttpSession session = request.getSession();
            listName = new ArrayList();
            rs = selectMess(request, userName);
            if (rs.next()) {
                rs = selectMess(request, userName);
                while (rs.next()) {
                    UserNameBean mess = new UserNameBean();
                    mess.setUserName(rs.getString("username"));
                    mess.setPassword(rs.getString("password"));
                    listName.add(mess);
                    session.setAttribute("userName", listName);
                }
            } else {
                session.setAttribute("userName", listName);
            }
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/


    //一个带参数的信息提示框，供找错是用
    public void message(String msg) {
        int type = JOptionPane.YES_NO_OPTION;
        String title = "信息提示";
        JOptionPane.showMessageDialog(null, msg, title, type);
    }
}