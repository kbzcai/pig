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
package com.pig4cloud.pig.ywzfjd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pig4cloud.pig.common.mybatis.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * zfjd 表
 *
 * @author pig code generator
 * @date 2022-10-10 11:15:09
 */
@Data
@TableName("yw_zfjd")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "zfjd 表")
public class YwZfjd extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description ="主键")
    private Long id;

    /**
     * 所属单位
     */
    @Schema(description ="所属单位")
    private String orderby;

    /**
     * 责任人
     */
    @Schema(description ="责任人")
    private String responsePeople;

    /**
     * 设备名称
     */
    @Schema(description ="设备名称")
    private String deviceName;

    /**
     * 外出地点
     */
    @Schema(description ="外出地点")
    private String outLocation;

    /**
     * 违法时间
     */
    @Schema(description ="违法时间")
    private LocalDateTime illegalTime;

    /**
     * 视频文件
     */
    @Schema(description ="视频文件")
    private String videoFile;

    /**
     * 违法行为
     */
    @Schema(description ="违法行为")
    private String illegalAction;

    /**
     * 状态
     */
    @Schema(description ="状态")
    private String status;

    /**
     * 案件号
     */
    @Schema(description ="案件号")
    private String caseNo;

    /**
     * 案件时间
     */
    @Schema(description ="案件时间")
    private LocalDateTime caseTime;

    /**
     * 案件名称
     */
    @Schema(description ="案件名称")
    private String caseName;

    /**
     * 案件类型
     */
    @Schema(description ="案件类型")
    private String caseType;

    /**
     * 立案机关
     */
    @Schema(description ="立案机关")
    private String caseOrgan;

    /**
     * 违法开始时间
     */
    @Schema(description ="违法开始时间")
    private LocalDateTime illegalStartTime;

    /**
     * 违法结束时间
     */
    @Schema(description ="违法结束时间")
    private LocalDateTime illegalEndTime;


}
