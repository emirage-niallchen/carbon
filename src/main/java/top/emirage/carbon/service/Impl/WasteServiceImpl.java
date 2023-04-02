package top.emirage.carbon.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.emirage.carbon.dao.WasteMapper;
import top.emirage.carbon.entity.Waste;
import top.emirage.carbon.service.WasteService;

/**
 * @author ChenBoyun
 * @date 2023-03-24 10:53
 */
@Service
public class WasteServiceImpl extends ServiceImpl<WasteMapper, Waste> implements WasteService {
}
