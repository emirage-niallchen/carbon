package top.emirage.carbon.entity;

/**
 * @author ChenBoyun
 * @date 2023-03-24 09:13
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Husbandry {
    @TableId(type = IdType.AUTO)
    @ExcelProperty("ID")
    private int id;
    @ExcelProperty("年份")
    private int year;
    @ExcelProperty("省份")
    private String province;
    @ExcelProperty("猪")
    private String pig;
    @ExcelProperty("牛")
    private String cow;
    @ExcelProperty("羊")
    private String sheep;




}
