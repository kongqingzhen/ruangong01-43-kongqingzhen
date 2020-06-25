package kong.dao;

import java.util.List;
import kong.entity.GamesEntity;

public interface gamedao {
    public List<GamesEntity> getByInfo(String name, String address);
    public  void  delete(int id);
    public  List<GamesEntity> list();
    public GamesEntity get(int id);
    public void add(GamesEntity game);
    public void delete(GamesEntity game);
    public void update(GamesEntity game);
}