package top.emirage.carbon.entity;

/**
 * @author ChenBoyun
 * @date 2023-03-24 09:15
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Industrial {
    @TableId(type = IdType.AUTO)
    @ExcelProperty("ID")
    private int id;
    @ExcelProperty("年份")
    private int year;
    @ExcelProperty("省份")
    private String province;
    @ExcelProperty("钢铁")
    private String steel;
    @ExcelProperty("水泥")
    private String cement;
    @ExcelProperty("合成氨")
    private String ammonia;



}
