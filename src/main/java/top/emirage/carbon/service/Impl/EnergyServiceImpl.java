package top.emirage.carbon.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.emirage.carbon.dao.EnergyMapper;
import top.emirage.carbon.entity.Energy;
import top.emirage.carbon.service.EnergyService;

/**
 * @author ChenBoyun
 * @date 2023-03-24 10:46
 */
@Service
public class EnergyServiceImpl extends ServiceImpl<EnergyMapper, Energy> implements EnergyService {
}
