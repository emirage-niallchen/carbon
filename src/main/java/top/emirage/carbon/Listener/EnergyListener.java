package top.emirage.carbon.Listener;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import top.emirage.carbon.entity.Energy;
import top.emirage.carbon.service.Impl.EnergyServiceImpl;

/**
 * @author ChenBoyun
 * @date 2023-03-25 06:28
 */
public class EnergyListener {
    @Autowired
    private EnergyServiceImpl energyService;
    public void importexcel(String filename){
        // 读取的excel文件路径

        // 读取excel
        EasyExcel.read(filename, Energy.class, new AnalysisEventListener<Energy>() {
            // 每解析一行数据,该方法会被调用一次
            @Override
            public void invoke(Energy energy, AnalysisContext analysisContext) {
//                System.out.println("解析数据为:" + energy.toString());
                energyService.save(energy);
            }
            // 全部解析完成被调用
            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("解析完成...");
                // 可以将解析的数据保存到数据库
            }
        }).sheet().doRead();
    }
}
