package top.emirage.carbon.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.emirage.carbon.dao.UserMapper;
import top.emirage.carbon.entity.User;
import top.emirage.carbon.service.UserService;

/**
 * @author ChenBoyun
 * @date 2023-03-24 10:52
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
