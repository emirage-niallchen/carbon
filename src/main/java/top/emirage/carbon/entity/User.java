package top.emirage.carbon.entity;

/**
 * @author ChenBoyun
 * @date 2023-03-24 09:18
 */
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
@Data
public class User {
    @TableId(type = IdType.AUTO)
    private int id;
    private int type;
    private String username;
    private String password;



}
