package Action;

import kong.dao.DBConn_CD;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import kong.entity.GamesEntity;
import org.apache.struts2.interceptor.SessionAware;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class upbookAction extends ActionSupport implements SessionAware {
    private GamesEntity game;
    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;
    private Map<String,Object> session;
    private ArrayList<GamesEntity> gameArrayList = new ArrayList<GamesEntity>();

    private String name;
    private String address;

    public GamesEntity getGame() {
        return game;
    }

    public void setGame(GamesEntity game) {
        this.game = game;
    }

    public ArrayList<GamesEntity> getGameArrayList() {
        return gameArrayList;
    }

    public void setGameArrayList(ArrayList<GamesEntity> gameArrayList) {
        this.gameArrayList = gameArrayList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {
        String sql="update games set name='"+name+"',address='"+address+"' where name ='"+name+"'";
        System.out.println(sql);
        String sql2="select * from games";
        conn= DBConn_CD.getConnection();
        stmt=conn.createStatement();
        int flag=stmt.executeUpdate(sql);
        if(flag!=0){
            rs=stmt.executeQuery(sql2);
            while(rs.next()){
                GamesEntity game = new GamesEntity();
                game.setName(rs.getString("Name"));
                game.setAddress(rs.getString("Address"));
                gameArrayList.add(game);
            }
            ActionContext ac= ActionContext.getContext();
            session=ac.getSession();
            session.put("gamesSession", this.gameArrayList);
            System.out.println(gameArrayList);

        }
        if (session.get("type").equals("管理员"))
            return "success_root";
//        return "success";
        else
            return "error";

    }
}
