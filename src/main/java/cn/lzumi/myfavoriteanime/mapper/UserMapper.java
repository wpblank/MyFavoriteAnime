package cn.lzumi.myfavoriteanime.mapper;

import cn.lzumi.myfavoriteanime.bean.User;
import org.apache.ibatis.annotations.*;

//操作数据库的Mapper
@Mapper
public interface UserMapper {
    @Select("select id,name,createTime,avatar from user where id=#{id}")
    User getUserById(Integer id);

    @Delete("delete from user where id=#{id}")
    int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into user(name,password) values(#{name},#{password})")
    int insertUser(User user);

    @Update("update user set password=#{password} where id=#{id}")
    int updateUser(User user);
}
