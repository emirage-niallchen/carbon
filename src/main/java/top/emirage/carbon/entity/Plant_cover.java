package top.emirage.carbon.entity;

/**
 * @author ChenBoyun
 * @date 2023-03-24 09:17
 */

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class Plant_cover {
    @TableId(type = IdType.AUTO)
    @ExcelProperty("ID")
    private int id;
    @ExcelProperty("年份")
    private int year;
    @ExcelProperty("省份")
    private String province;
    @ExcelProperty("森林")
    private String forest;
    @ExcelProperty("耕地")
    private String farmland;
    @ExcelProperty("城市绿化")
    private String greening;

}
