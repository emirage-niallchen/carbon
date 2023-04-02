package top.emirage.carbon.entity;

/**
 * @author ChenBoyun
 * @date 2023-03-24 09:12
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Basic {
    @TableId(type = IdType.AUTO)
    @ExcelProperty("ID")
    private int id;
    @ExcelProperty("年份")
    private int year;
    @ExcelProperty("省份")
    private String province;
    @ExcelProperty("GDP总量")
    private String economy;
    @ExcelProperty("人口总数")
    private String population;

}
