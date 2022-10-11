/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */
package com.pig4cloud.pig.rule.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pig4cloud.pig.common.mybatis.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 规则定义
 *
 * @author pig code generator
 * @date 2022-10-11 14:57:46
 */
@Data
@TableName("rule")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "规则定义")
public class Rule extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description ="主键")
    private Long id;

    /**
     * 规则名称
     */
    @Schema(description ="规则名称")
    private String ruleName;

    /**
     * 规则简要说明
     */
    @Schema(description ="规则简要说明")
    private String ruleDescription;

    /**
     * 状态
     */
    @Schema(description ="状态")
    private String ruleStatus;

    /**
     * 生效日期
     */
    @Schema(description ="生效日期")
    private LocalDateTime startTime;

    /**
     * 停用日期
     */
    @Schema(description ="停用日期")
    private LocalDateTime stopTime;


}
