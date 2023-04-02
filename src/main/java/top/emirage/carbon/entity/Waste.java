package top.emirage.carbon.entity;


import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author ChenBoyun
 * @date 2023-03-24 09:19
 */

@Data//Incineration Landfill Oxygen demand
public class Waste {
    @TableId(type = IdType.AUTO)
    @ExcelProperty("ID")
    private int id;
    @ExcelProperty("年份")
    private int year;
    @ExcelProperty("省份")
    private String province;
    @ExcelProperty("垃圾填埋")
    private String incineration;
    @ExcelProperty("垃圾焚烧")
    private String landfill;
    @ExcelProperty("需氧量")
    private String oxygen;



}
