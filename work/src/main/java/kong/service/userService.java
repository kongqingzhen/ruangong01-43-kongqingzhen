package kong.service;

import kong.entity.UsersEntity;
import java.math.BigDecimal;
import java.util.List;


public interface userService {
    public boolean addUser(UsersEntity user);
    public boolean rootlogin(UsersEntity user);
    public boolean login(UsersEntity user);

    public List<UsersEntity> list();

    public UsersEntity getUserById(int id);

    public void update(UsersEntity user);

    public boolean delete(int id);

    public UsersEntity getUserByUsername(String username);


}