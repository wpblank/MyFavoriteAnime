package cn.lzumi.myfavoriteanime.mapper;

import cn.lzumi.myfavoriteanime.bean.User;
import cn.lzumi.myfavoriteanime.bean.LoginInfo;
import org.apache.ibatis.annotations.*;

//操作数据库的Mapper
@Mapper
public interface UserMapper {
    @Select("select id,name,createTime,avatar from user where id=#{id}")
    User getUserById(Integer id);

    @Select("select cookie from user where id=#{id}")
    String getCookieById(Integer id);

    @Select("select password,cookie from user where name=#{name}")
    String getPassword(User user);

    //查询用户名是否已存在
    @Select("select * from user where name=#{name}")
    String getUserByName(String name);

    /**
     * 查询是否已登录
     * @param token 传入客户端
     * @return "true"-->已登录  ""-->未登录
     */
    @Select("select name,avatar from user where cookie=#{token}")
    User isLoginByToken(String token);

    @Delete("delete from user where id=#{id}")
    int deleteDeptById(Integer id);

    //添加用户
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(name,password,cookie,createTime,avatar) values(#{name},#{password},#{cookie},#{createTime},#{avatar})")
    int insertUser(User user);

    //保存登录信息
    @Insert("insert into logininfo(name,loginTime,state) values(#{name},#{loginTime},#{state})")
    void insertLoginInfo(LoginInfo loginInfo);

    @Update("update user set cookie=#{cookie} where name=#{name}")
    int updateCookie(User user);

    //修改密码
    @Update("update user set password=#{password},cookie=#{cookie} where id=#{id}")
    int updatePassword(User user);

    //修改头像
    @Update("update user set avatar=#{avatar} where id=#{id}")
    int updateAvatar(User user);

}
