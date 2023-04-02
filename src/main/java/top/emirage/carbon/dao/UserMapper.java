package top.emirage.carbon.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.emirage.carbon.entity.User;


@Mapper
public interface UserMapper extends BaseMapper<User> {
}
