package cn.manager.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Data
@TableName("role")
public class Role {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "name")
    @NotBlank(message = "{required}")
    private String name;

    @TableField(value = "description")
    private String description;

    @TableField(value = "create_time")
    private Date createTime;
}
