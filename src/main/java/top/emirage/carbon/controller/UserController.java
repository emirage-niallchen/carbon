package top.emirage.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import top.emirage.carbon.annotation.PassToken;
import top.emirage.carbon.annotation.UserLoginToken;
import top.emirage.carbon.utils.MyUtils;
import top.emirage.carbon.entity.User;
import top.emirage.carbon.service.Impl.UserServiceImpl;

import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-24 11:09
 */
@Controller
public class UserController {


    @Autowired
    private UserServiceImpl userService;


    @PassToken
    @RequestMapping(path = "/user/update",method = RequestMethod.POST)
    @ResponseBody
    public String update(String id,
                         String username,String password,String type){
        userService.removeById(Integer.parseInt(id));
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(Integer.parseInt(type));
        userService.save(user);
        return  MyUtils.getJSONString(0, "修改成功!");
    }


    @PassToken
    @RequestMapping(path = "/user/findById",method = RequestMethod.GET)
    @ResponseBody
    public User findbyid(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){

        User user = userService.getById(id);
        return user;
    }

    @UserLoginToken
    @RequestMapping(path = "/user/list",method = RequestMethod.GET)
    public String getuserlist(Model model){
        List<User> userlist = userService.list();
        model.addAttribute("userlist",userlist);
        System.out.println("点击了");
        return "crud/user_crud";
    }

    @PassToken
    @RequestMapping(path = "/user/del", method = RequestMethod.POST)
    @ResponseBody
    public String setDelete(int id){
        userService.removeById(id);

        return MyUtils.getJSONString(0);
    }

    @PassToken
    @RequestMapping(path = "/user/add",method = RequestMethod.POST)
    @ResponseBody
    public String adduser(String username,String password,String type){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setType(Integer.parseInt(type));
        userService.save(user);
        return  MyUtils.getJSONString(0, "发布成功!");
    }

    @PassToken
    @RequestMapping(path = "/user/search",method = RequestMethod.GET)
    public String usersearch(@RequestParam(required = false) @PathVariable("province") String province, Model model){
        model.addAttribute("province",province);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();



        queryWrapper.eq("province",province);


        List<User> userlist = userService.list(queryWrapper);
        model.addAttribute("userlist",userlist);
        return "crud/user_crud";
    }
}
