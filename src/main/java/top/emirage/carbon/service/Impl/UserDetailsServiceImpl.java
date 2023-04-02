//package top.emirage.carbon.service.Impl;
//
//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import top.emirage.carbon.dao.UserMapper;
//import top.emirage.carbon.entity.LoginUser;
//import top.emirage.carbon.entity.User;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Objects;
//
///**
// * @author ChenBoyun
// * @date 2023-03-26 22:37
// */
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        //根据用户名查询用户信息
//        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
//        wrapper.eq(User::getUsername, username);
//        User user = userMapper.selectOne(wrapper);
//        //如果查询不到数据就通过抛出异常来给出提示
//        if (Objects.isNull(user)) {
//            throw new RuntimeException("用户名或密码错误");
//        }
//        //TODO 根据用户查询权限信息 添加到LoginUser中
//
//        List<String> list = new ArrayList<>(Arrays.asList("admin"));
//        //封装成UserDetails对象返回
//        return new LoginUser(user,list);
//    }
//}
