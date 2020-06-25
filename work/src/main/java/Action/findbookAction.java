package Action;

import kong.dao.DBConn_CD;
import kong.entity.GamesEntity;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

public class findbookAction extends ActionSupport implements SessionAware {
    private GamesEntity game;
    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;
    private Map<String,Object> session;
    private ArrayList<GamesEntity> gameArrayList = new ArrayList<GamesEntity>();
    private String find;

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

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public ArrayList<GamesEntity> getBookArrayList() {
        return gameArrayList;
    }

    public void setBookArrayList(ArrayList<GamesEntity> bookArrayList) {
        this.gameArrayList = bookArrayList;
    }

    public Map<String, Object> getSession() {
        return session;
    }

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public GamesEntity getGame() {
        return game;
    }

    public void setGame(GamesEntity book) {
        this.game = book;
    }

    public String execute() throws Exception{
        find="%"+find+"%";
        String sql="select * from games where name like '"+find+"'";
        conn = DBConn_CD.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery(sql);
        while (rs.next()){
            GamesEntity game =new GamesEntity();
            game.setName(rs.getString("Name"));
            game.setAddress(rs.getString("Address"));
            gameArrayList.add(game);

        }
        String model=(String)session.get("type");
        System.out.println("本次权限"+model);
        ActionContext ac= ActionContext.getContext();
        session=ac.getSession();
        session.put("findgameSession", this.gameArrayList);
        System.out.println(gameArrayList);
        if (model.equals("管理员")){
            return "success_root";
        }else
            return "success_user";

    }

}
