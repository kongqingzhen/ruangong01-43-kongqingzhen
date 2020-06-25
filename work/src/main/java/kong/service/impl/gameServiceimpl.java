package kong.service.impl;

import kong.service.gameService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import kong.entity.GamesEntity;
import kong.dao.gamedao;
import javax.annotation.Resource;
import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
@Service("gameService")
@Scope("prototype")
public class gameServiceimpl implements gameService {

    @Resource(name = "gamedao")
    private gamedao gameDao;

    public gamedao getGameDao() {
        return gameDao;
    }

    public void setGameDao(gamedao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public List<GamesEntity> getByInfo(String name, String address) {

        System.out.println("224");

        return gameDao.getByInfo(name, address);
    }

    @Override
    public GamesEntity get(int id) {
        return gameDao.get(id);
    }

    @Override
    public void add(GamesEntity game) {
        game.setName(game.getName());
        game.setAddress(game.getAddress());
        gameDao.add(game);
    }

    @Override
    public List<GamesEntity> list() {
        List<GamesEntity> books = gameDao.list();
        System.out.println("123");
        if (books.isEmpty()) {
            for (int i = 0; i < 2; i++) {
                GamesEntity book = new GamesEntity();
                book.setName("book" + i);
                gameDao.add(book);
                books.add(book);
            }
        }

        return books;
    }

    public void delete(GamesEntity book) {
        gameDao.delete(book);
    }

    public void update(GamesEntity book) {
        gameDao.update(book);
    }

    public void delete(int id) {
        gameDao.delete(id);
    }
}
