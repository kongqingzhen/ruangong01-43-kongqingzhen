package kong.action;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import kong.entity.UsersEntity;
import kong.entity.GamesEntity;
import kong.service.gameService;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

@Controller("gameaction")
@Scope("prototype")
public class gameaction implements ServletResponseAware {

    @Resource(name = "gameService")
    private gameService gameService;
    private GamesEntity game;

    public kong.service.gameService getGameService() {
        return gameService;
    }

    public void setGameService(kong.service.gameService gameService) {
        this.gameService = gameService;
    }

    private javax.servlet.http.HttpServletResponse response;


    private List<GamesEntity> games;
    private String username;
    private  UsersEntity user;


    // 获得HttpServletResponse对象
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public GamesEntity getGame() {
        return game;
    }

    public void setGame(GamesEntity game) {
        System.out.println("132142");
        this.game = game;
    }

    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        System.out.println("132146");
        this.user = user;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("132143");
        this.username=username;

    }



    public List<GamesEntity> getGames() {
        System.out.println("2");
        return games;
    }

    public void setGames(List<GamesEntity> games) {
        System.out.println("132144");
        this.games = games;
    }



    //select book
    public String select()
    {
        System.out.println("3");
        games=gameService.getByInfo(game.getName(),game.getAddress());
        System.out.println(games.get(0).getName());
        return SUCCESS;
    }

    //select book by bookid
    public String getById(int bookid)
    {

        System.out.println("4");
        gameService.get(bookid);

        return SUCCESS;
    }

    //show all book
    public  String list()
    {
        System.out.println("5");
        games=gameService.list();

        System.out.println("9");
        return  "listBook";
    }

    public  String mList()
    {
        System.out.println("5");
        games=gameService.list();

        System.out.println("9");
        return  "mListBook";
    }
    // add book
    public  String add()
    {
        System.out.println("6");
        gameService.add(game);
        print();
        return "listBookAction";
    }


    //edit  book
    public String edit()
    {
        System.out.println();
        game=gameService.get(game.getId());
        print();
        return  "editBook";
    }

    public String delete(){
        gameService.delete(game.getId());
        print();
        return  "listBookAction";
    }

    public String update()
    {
        System.out.println("7");
        gameService.update(game);

        return  "listBookAction";
    }
    private void print()
    {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");//防止弹出的信息出现乱码
        try {
            PrintWriter out = response.getWriter();
            out.print("<script>alert('操作成功！')</script>");
            out.print("<script>window.location.href='successManage.jsp '</script>");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}