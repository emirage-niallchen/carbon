//package top.emirage.carbon.service.Impl;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//import top.emirage.carbon.entity.LoginUser;
//import top.emirage.carbon.entity.User;
//import top.emirage.carbon.service.LoginService;
//import top.emirage.carbon.utils.JwtUtil;
//import top.emirage.carbon.utils.RedisCache;
//import top.emirage.carbon.utils.ResponseResult;
//
//import java.util.HashMap;
//import java.util.Objects;
//
///**
// * @author ChenBoyun
// * @date 2023-03-26 22:47
// */
//@Service
//public class LoginServiceImpl implements LoginService {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    @Autowired
//    private RedisCache redisCache;
//
//    @Override
//    public ResponseResult login(User user) {
//        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
//        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
//        if(Objects.isNull(authenticate)){
//            throw new RuntimeException("用户名或密码错误");
//        }
//        //使用userid生成token
//        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
//        String userId = loginUser.getUser().getId()+"";
//        String jwt = JwtUtil.createJWT(userId);
//        //authenticate存入redis
//        redisCache.setCacheObject("login:"+userId,loginUser);
//        //把token响应给前端
//        HashMap<String,String> map = new HashMap<>();
//        map.put("token",jwt);
//        return new ResponseResult(200,"登陆成功",map);
//    }
//
//    @Override
//    public ResponseResult logout() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
//        Long userid = loginUser.getUser().getId();
//        redisCache.deleteObject("login:"+userid);
//        return new ResponseResult(200,"退出成功");
//    }
//
//}
