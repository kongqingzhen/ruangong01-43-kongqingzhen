package kong.dao.impl;

import kong.dao.gamedao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import kong.entity.GamesEntity;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Scope("prototype")
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("gamedao") //进行注入
public class gamedaoimpl implements gamedao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    private String name;
    private  GamesEntity game;
    private  String username;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<GamesEntity> getList() {
        return list;
    }

    public void setList(List<GamesEntity> list) {
        this.list = list;
    }

    private List<GamesEntity> list;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public GamesEntity getGame() {
        return game;
    }

    public void setGame(GamesEntity game) {
        this.game = game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public List<GamesEntity> getByInfo(String name, String address) {


        Session session=sessionFactory.getCurrentSession();

        StringBuffer hql= new StringBuffer();

        hql.append(  "from games g where 1=1 ");


        if (name.length()!=0) {

            hql.append("and g.name like '%").append(name).append("%'");
        }

        if (address.length()!=0)
            hql.append("and g.addrss like '%" + address + "%'");



        Query query=session.createQuery(hql.toString());

        list=query.list();

        return list;
    }





    public void delete(int id)
    {

        Session session=sessionFactory.getCurrentSession();
        String hql="delete from games game where game.id=?";
        Query query=session.createQuery(hql);
        query.setParameter(0 ,id) ;
        query.executeUpdate();

    }


    public List<GamesEntity> list()
    {
        System.out.println("110");
        try{
            Session session=sessionFactory.getCurrentSession();
            Query query= session.createQuery("from games");
            System.out.println("111");
            list = query.list();

            System.out.println("112");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        System.out.println("!!!"+list.get(0).getAddress());
        return  list;
    }


    public GamesEntity get(int id)
    {
        System.out.println("b1");
        System.out.println(id);
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from games game where game.id=?");
        query.setParameter(0,id);
        return (GamesEntity) query.list().get(0);
    }

    public void add(GamesEntity game)
    {
        System.out.println(game.getId());
        Session session=sessionFactory.getCurrentSession();

        session.save(game);
//        Query query=session.createQuery("select ifnull(b.mount,0) from Book b");
        System.out.println(
                "tushu"+game.getId());
        System.out.println("addbook success");
    }

    public void delete(GamesEntity game)
    {
        Session session=sessionFactory.getCurrentSession();
        session.delete(game);

    }

    public void update(GamesEntity  game)
    {
        Session session=sessionFactory.getCurrentSession();
        session.update(game);
        System.out.println("updatebook success");
    }
}