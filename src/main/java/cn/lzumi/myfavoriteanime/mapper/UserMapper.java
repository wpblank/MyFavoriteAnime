package cn.lzumi.myfavoriteanime.mapper;

import cn.lzumi.myfavoriteanime.bean.User;
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

    //查询用户是否登陆
    @Select("select * from user where cookie=#{token}")
    Boolean isLoginByToken(String token);

    @Delete("delete from user where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(name,password,cookie,createTime) values(#{name},#{password},#{cookie},#{createTime})")
    int insertUser(User user);

    @Update("update user set cookie=#{cookie} where name=#{name}")
    int updateCookie(User user);

    //修改密码
    @Update("update user set password=#{password},cookie=#{cookie} where id=#{id}")
    int updatePassword(User user);

    //修改头像
    @Update("update user set avatar=#{avatar} where id=#{id}")
    int updateAvatar(User user);

}
