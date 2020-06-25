package kong.dao;

import kong.entity.UsersEntity;

import java.util.List;


public interface userdao {
    /**
     * 添加并保存用户
     * @param user
     */
    public void add(UsersEntity user);

    /**
     * 进行登录
     */
    public boolean login(UsersEntity user);

    public boolean rootlogin(UsersEntity user);
    /**
     * 获取用户列表
     */
    public List getUser();

    /**
     * 根据用户Id获取用户信息
     * @param id
     * @return
     */
    public UsersEntity getUser(int id);

    /**
     * 更新用户信息
     * @param user
     */
    public void update(UsersEntity user);


    /**
     * 根据用户id删除用户信息
     * @param id
     */
    public void delete(int id);

    public  UsersEntity getUserByInfo(String username);




}
