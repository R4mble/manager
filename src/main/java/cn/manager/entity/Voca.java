package cn.manager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author Wangyl
 * @date 2019/9/27
 */
@Data
@TableName("voca")
public class Voca {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("user_id")
    private Long userId;

    // 单词
    @TableField("content")
    private String content;
    // 发音
    @TableField("pronounce")
    private String pronounce;
    // 音标
    @TableField("phonetic")
    private String phonetic;
    // 句子
    @TableField("sentence")
    private String sentence;

    @TableField("create_time")
    private Date createTime;
}
