package top.emirage.carbon.entity;

/**
 * @author ChenBoyun
 * @date 2023-03-22 13:07
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Energy {
    @TableId(type = IdType.AUTO)
    @ExcelProperty("ID")
    private int id;
    @ExcelProperty("年份")
    private int year;
    @ExcelProperty("省份")
    private String province;
    @ExcelProperty("原油")
    private String oil;
    @ExcelProperty("煤炭")
    private String coal;
    @ExcelProperty("天然气")
    private String gas;
    @ExcelProperty("折煤总量")
    private String total;
}
