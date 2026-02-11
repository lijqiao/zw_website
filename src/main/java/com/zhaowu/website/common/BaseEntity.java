package com.zhaowu.website.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {
    private int deleted;
    @TableId(type = IdType.AUTO)
    private Long id;
    /** 记录创建时间（自动填充） */
    private LocalDateTime createTime;
    /** 记录更新时间（自动更新） */
    private LocalDateTime updateTime;
    /** 创建者 */
    private String createId;
    /** 更新者 */
    private String updateId;
}
