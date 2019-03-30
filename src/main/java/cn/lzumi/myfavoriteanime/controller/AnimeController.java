package cn.lzumi.myfavoriteanime.controller;

import cn.lzumi.myfavoriteanime.bean.Anime;
import cn.lzumi.myfavoriteanime.mapper.AnimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimeController {
    @Autowired
    AnimeMapper animeMapper;

    @GetMapping("/anime/{id}")
    public Anime getAnime(@PathVariable("id") Integer id){
        return animeMapper.getAnimeById(id);
    }
}
