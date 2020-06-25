package kong.service.impl;

import kong.dao.userdao;
import kong.entity.UsersEntity;
import kong.service.userService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
//注入服务
@Service("userService")
@Scope("prototype")
public class userServiceimpl implements userService {
    //自动注入userDao，也可以使用@Autowired
    @Resource(name="userDao")
    private userdao userDao;


    public userdao getUserDao() {
        return userDao;
    }

    public void setUserDao(userdao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean addUser(UsersEntity user) {
        System.out.println("21321");
        this.userDao.add(user);

        return true;
    }
    @Override
    public boolean rootlogin(UsersEntity user) {
        return userDao.login(user);
    }

    @Override
    public boolean login(UsersEntity user) {
        return userDao.login(user);
    }

    @Override
    public List<UsersEntity> list() {
        return this.userDao.getUser();
    }

    @Override
    public UsersEntity getUserById(int id) {
        return this.userDao.getUser(id);
    }

    @Override
    public void update(UsersEntity user) {
        this.userDao.update(user);
    }

    @Override
    public boolean delete(int id) {
        this.userDao.delete(id);
        return true;
    }


    public UsersEntity getUserByUsername(String username)
    {
        return userDao.getUserByInfo(username);

    }


}
