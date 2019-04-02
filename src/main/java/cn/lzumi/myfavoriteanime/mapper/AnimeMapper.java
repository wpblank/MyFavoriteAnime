package cn.lzumi.myfavoriteanime.mapper;

import cn.lzumi.myfavoriteanime.bean.Anime;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AnimeMapper {
    @Select("select * from anime where id=#{id}")
    Anime getAnimeById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into anime(name,comment,pic,bilibili,bt) values(#{name},#{comment},#{pic},#{bilibili},#{bt})")
    int insertAnime(Anime anime);

    @Delete("delete from anime where id=#{id}")
    int deleteAnimeById(Integer id);

    //更新简介
    @Update("update anime set comment=#{comment} where id=#{id}")
    int updateComment(Anime anime);
}
