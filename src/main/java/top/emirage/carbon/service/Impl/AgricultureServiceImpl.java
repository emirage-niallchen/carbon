package top.emirage.carbon.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.emirage.carbon.dao.AgricultureMapper;
import top.emirage.carbon.entity.Agriculture;
import top.emirage.carbon.service.AgricultureService;

/**
 * @author ChenBoyun
 * @date 2023-03-24 10:43
 */
@Service
public class AgricultureServiceImpl extends ServiceImpl<AgricultureMapper, Agriculture> implements AgricultureService {
}
