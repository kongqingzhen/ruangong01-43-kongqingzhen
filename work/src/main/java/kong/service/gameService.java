package kong.service;
import kong.entity.GamesEntity;
import java.util.List;

public interface gameService {
    public List<GamesEntity> getByInfo(String name, String address);
    public GamesEntity get(int id);
    public List<GamesEntity> list();

    public void add(GamesEntity game);
    public void update(GamesEntity  game);
    public  void  delete(int id);
}

