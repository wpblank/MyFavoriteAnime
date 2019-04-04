package cn.lzumi.myfavoriteanime.mapper;

import cn.lzumi.myfavoriteanime.bean.Anime;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AnimeMapper {

    @Select("select * from anime where id=#{id}")
    Anime getAnimeById(Integer id);

    //查询所有动画id
    @Select("select id from anime")
    List<Integer> getAllId();

    //随机获取动画信息
    @Select("Select * From anime Order By rand() Limit 4")
    List<Anime> getAnimeByRand();

    //添加动画信息
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into anime(name,comment,pic,bilibili,bt) values(#{name},#{comment},#{pic},#{bilibili},#{bt})")
    int insertAnime(Anime anime);

    @Delete("delete from anime where id=#{id}")
    int deleteAnimeById(Integer id);

    //更新简介
    @Update("update anime set comment=#{comment} where id=#{id}")
    int updateComment(Anime anime);
}
