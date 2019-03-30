package cn.lzumi.myfavoriteanime.mapper;

import cn.lzumi.myfavoriteanime.bean.Anime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnimeMapper {
    @Select("select * from anime where id=#{id}")
    Anime getAnimeById(Integer id);
}
