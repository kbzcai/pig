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
package com.pig4cloud.pig.equipment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pig4cloud.pig.common.mybatis.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 设备管理
 *
 * @author pig code generator
 * @date 2022-10-11 09:53:51
 */
@Data
@TableName("equipment_manage")
@EqualsAndHashCode(callSuper = true)
@Schema(description = "设备管理")
public class EquipmentManage extends BaseEntity {

    /**
     * 主键
     */
    @TableId(type = IdType.ASSIGN_ID)
    @Schema(description ="主键")
    private Long id;

    /**
     * 设备编号
     */
    @Schema(description ="设备编号")
    private String equipmentNo;

    /**
     * 责任人
     */
    @Schema(description ="责任人")
    private String responsePeople;

    /**
     * 设备状态
     */
    @Schema(description ="设备状态")
    private String equipmentStatus;

    /**
     * 外出地点
     */
    @Schema(description ="外出地点")
    private String equipmentCh;

    /**
     * 启用日期
     */
    @Schema(description ="启用日期")
    private LocalDateTime startTime;

    /**
     * 停用日期
     */
    @Schema(description ="停用日期")
    private LocalDateTime stopTime;


}
