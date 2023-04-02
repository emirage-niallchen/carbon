package top.emirage.carbon.entity;

/**
 * @author ChenBoyun
 * @date 2023-03-24 09:08
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Agriculture {
    @ExcelProperty("ID")
    @TableId(type = IdType.AUTO)
    private int id;
    @ExcelProperty("年份")
    private int year;
    @ExcelProperty("省份")
    private String province;
    @ExcelProperty("灌溉量")
    private String irrigation;
    @ExcelProperty("农机使用")
    private String machinery;
    @ExcelProperty("化肥用量")
    private String fertilizer;
    @ExcelProperty("耕作总面积")
    private String area;

}
