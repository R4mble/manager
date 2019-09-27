package cn.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
@Data
@TableName("menu")
public class Menu {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("parent_id")
    private Integer parentId;

    @TableField("name")
    private String name;

    @TableField("url")
    private String url;

    @TableField("perm")
    private String perm;

    @TableField("icon")
    private String icon;

    @TableField("create_time")
    private Date createTime;
}
