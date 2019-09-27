package cn.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Data
@TableName("user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("name")
    @Size(min = 4, max = 10, message = "{range}")
    private String name;

    @TableField("password")
    @Size(min = 4, max = 16, message = "{range}")
    private String password;

    @TableField("avatar")
    private String avatar;

    @TableField("gender")
    private Integer gender;

    @TableField("description")
    private String description;

    @TableField("create_time")
    private Date createTime;
}
