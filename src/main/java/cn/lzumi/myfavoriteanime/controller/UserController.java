package cn.lzumi.myfavoriteanime.controller;

import cn.lzumi.myfavoriteanime.bean.User;
import cn.lzumi.myfavoriteanime.mapper.UserMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id") Integer id) {
        return userMapper.getUserById(id);
    }

    //查看用户名是否存在
    @RequestMapping(value = "/register/{name}", method = RequestMethod.GET)
    public String getUserName(@PathVariable("name") String name) {
        if (userMapper.getUserByName(name) != null) {
            return "用户名已存在";
        } else
            return "用户名不存在";
    }

    //查看登陆状态
    @RequestMapping(value = "/login/{token}", method = RequestMethod.GET)
    public User isLogin(@PathVariable("token") String token){
        return userMapper.isLoginByToken(token);
    }


    // 处理"/users/"的POST请求，用来创建User
    // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        user.setPassword(DigestUtils.md5Hex(user.getPassword()));   //以md5方式保存密码
        user.setCookie(UUID.randomUUID().toString());               //生成token
        user.setCreateTime(new Date());
        //System.out.println(user.getCookie()+user.getCreateTime());
        userMapper.insertUser(user);
        return user.getName() + " 添加成功";
    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public String loginUser(@ModelAttribute User user) {

        if (user.getPassword().equals(userMapper.getPassword(user))) {
            String token = UUID.randomUUID().toString();
            user.setCookie(token);
            userMapper.updateCookie(user);
            return "登陆成功" + token;
        }
//        else if (userMapper.getUserByName(user.getName()) == null)
//            return "账号错误";
        else
            return "密码错误";
    }


    /**
     * 修改密码、头像
     *
     * @param id   账号id
     * @param user PUT中带上cookie
     *             password：更改的密码
     *             avatar：头像链接
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable int id, @ModelAttribute User user) {
        if (userMapper.getCookieById(id).equals(user.getCookie())) {
            // 处理"/user/{id}"的PUT请求，用来更新User信息
            if (user.getPassword() != null) {    //修改密码
                user.setPassword(DigestUtils.md5Hex(user.getPassword()));
                user.setCookie(UUID.randomUUID().toString());
                userMapper.updatePassword(user);
            }
            if (user.getAvatar() != null)  //修改头像
                userMapper.updateAvatar(user);
            return "修改成功";
        } else
            return "无权限修改";
    }

    // 处理"/users/{id}"的DELETE请求，用来删除User
    // 需要传入cookie，且只能删除cookie对应id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id, @ModelAttribute User user) {
        if (userMapper.getCookieById(id).equals(user.getCookie())) {
            return userMapper.deleteDeptById(id) + "删除成功";
        } else return "无权限删除";
    }
}
