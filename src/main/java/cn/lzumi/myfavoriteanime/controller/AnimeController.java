package cn.lzumi.myfavoriteanime.controller;

import cn.lzumi.myfavoriteanime.bean.Anime;
import cn.lzumi.myfavoriteanime.mapper.AnimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/anime")
public class AnimeController {

    @Autowired
    AnimeMapper animeMapper;

    //查询动画信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Anime getAnime(@PathVariable("id") Integer id) {
        return animeMapper.getAnimeById(id);
    }

    //随机获取动画信息
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Anime> getAnimeByRand() {
        return animeMapper.getAnimeByRand();
    }

    //增加动画信息
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postAnime(@ModelAttribute Anime anime) {
        try {
            int a = animeMapper.insertAnime(anime);
            if (a > 0)
                return "添加成功";
            return "添加失败";
        } catch (Exception e) {
            return "添加失败";
        }
    }

    //删除动画信息
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteAnime(@PathVariable("id") Integer id) {
        return "删除成功" + animeMapper.deleteAnimeById(id);
    }

    //更新动画信息
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable int id, @ModelAttribute Anime anime) {
        // 处理"/anime/{id}"的PUT请求，用来更新Anime信息
        if (anime.getComment() != null)    //修改简介
            animeMapper.updateComment(anime);
        return "success";
    }
}
