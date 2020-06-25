package kong.dao.impl;

import kong.dao.userdao;
import kong.entity.UsersEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


@Scope("prototype")
@Transactional(rollbackFor = Exception.class)
//出现Exception异常回滚
@Repository("userDao") //进行注入
public class userdaoimpl implements userdao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    private  UsersEntity user;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    @Override
    public void add(UsersEntity user) {
        try{
            System.out.println("21321");
            System.out.println(user.getName());
            Session session=sessionFactory.getCurrentSession();
            session.save(user);
            System.out.println(user.getId());
            System.out.println(user.getName());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

        }
    }
    @Override
    public boolean rootlogin(UsersEntity user) {
        Iterator<UsersEntity> it;
        String hsql="FROM users u where u.username='root' and u.password='123456'";
        System.out.println(hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getName());
        query.setString(1, user.getPassword());
        System.out.println(user.getName());
        it=query.iterate();
        if(it.hasNext()) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    @Override
    public boolean login(UsersEntity user) {
        Iterator<UsersEntity> it;
        String hsql="FROM users u where u.username=? and u.password=?";
        System.out.println(hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getName());
        query.setString(1, user.getPassword());
        System.out.println(user.getName());
        it=query.iterate();
        if(it.hasNext()) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    @Override
    public List getUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM users").list();
    }

    @Override
    public UsersEntity getUser(int id) {
        return (UsersEntity)sessionFactory.getCurrentSession().get(UsersEntity.class, id);
    }

    @Override
    public void update(UsersEntity user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(int id) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(UsersEntity.class, id)
        );
    }
    @Override
    public  UsersEntity getUserByInfo(String username)
    {
        System.out.println(username);
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from users u where u.username= ?");
        query.setParameter(0,username);


        return  (UsersEntity) query.list().get(0);





    }

}
