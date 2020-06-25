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

public class book_message extends ActionSupport implements SessionAware {
    private GamesEntity game;
    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rs;
    private Map<String,Object> session;
    private ArrayList<GamesEntity> gameArrayList = new ArrayList<GamesEntity>();

    public Map<String, Object> getSession() {
        return session;
    }

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

    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {
        String sql="select * from games";
        conn= DBConn_CD.getConnection();
        stmt=conn.createStatement();
        rs=stmt.executeQuery(sql);
        while (rs.next()){
            GamesEntity game =new GamesEntity();
            game.setName(rs.getString("Name"));
            game.setAddress(rs.getString("Address"));
            gameArrayList.add(game);
        }
        ActionContext ac= ActionContext.getContext();
        session=ac.getSession();
        session.put("gameSession", this.gameArrayList);
        System.out.println(gameArrayList);
        return "success";
    }

}

