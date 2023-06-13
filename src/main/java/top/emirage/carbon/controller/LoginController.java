package top.emirage.carbon.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.emirage.carbon.entity.User;
import top.emirage.carbon.service.Impl.UserServiceImpl;

//import top.emirage.carbon.utils.TokenUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ChenBoyun
 * @date 2023-03-31 19:16
 */
@Controller
public class LoginController {



    @GetMapping(path = "/admin")
    public String aaa(){
        return "login";
    }


    @Autowired
    UserServiceImpl userService;

    @RequestMapping(path = "/login" , method = RequestMethod.POST)
    public String user_login(String username, String password, HttpServletRequest request,HttpServletResponse response){


        if(username == null||password == null ){
            return "login";
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        User user = userService.getOne(queryWrapper);
        if(user == null||!user.getPassword().equals(password)) {
            request.setAttribute("msg", "用户名密码");
            return "login";
        }
        StpUtil.login(user.getId());
        StpUtil.getSession().set("user", user);



//        String token = TokenUtils.token(username,password);
        //Cookie cookie=new Cookie("token",token);
        //cookie.setMaxAge(365*24*60*60);     //存活一年
//        response.addCookie(cookie);
//        HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(request);
        return "redirect:/energy/list";
    }


    @RequestMapping(path = "/logout",method = RequestMethod.GET)
    public String logout(){
        User user = (User) StpUtil.getSession().get("user");
        StpUtil.logout(user.getId());
        return "redirect:/login";
    }


}
