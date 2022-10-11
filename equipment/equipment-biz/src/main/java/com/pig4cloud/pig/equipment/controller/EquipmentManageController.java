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

package com.pig4cloud.pig.equipment.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.equipment.entity.EquipmentManage;
import com.pig4cloud.pig.equipment.service.EquipmentManageService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 设备管理
 *
 * @author pig code generator
 * @date 2022-10-11 09:53:51
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/equipmentmanage" )
@Tag(name = "设备管理管理")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class EquipmentManageController {

    private final  EquipmentManageService equipmentManageService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param equipmentManage 设备管理
     * @return
     */
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('equipment_equipmentmanage_get')" )
    public R getEquipmentManagePage(Page page, EquipmentManage equipmentManage) {
		QueryWrapper wrapper= new QueryWrapper();
		if(!equipmentManage.getEquipmentNo().equals("")){
			wrapper.like("equipment_no",equipmentManage.getEquipmentNo());
		}
		if (!equipmentManage.getEquipmentStatus().equals("")){
			wrapper.eq("equipment_status",equipmentManage.getEquipmentStatus());
		}
        return R.ok(equipmentManageService.page(page, wrapper));
    }


    /**
     * 通过id查询设备管理
     * @param id id
     * @return R
     */
    @Operation(summary = "通过id查询", description = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('equipment_equipmentmanage_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(equipmentManageService.getById(id));
    }

    /**
     * 新增设备管理
     * @param equipmentManage 设备管理
     * @return R
     */
    @Operation(summary = "新增设备管理", description = "新增设备管理")
    @SysLog("新增设备管理" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('equipment_equipmentmanage_add')" )
    public R save(@RequestBody EquipmentManage equipmentManage) {
        return R.ok(equipmentManageService.save(equipmentManage));
    }

    /**
     * 修改设备管理
     * @param equipmentManage 设备管理
     * @return R
     */
    @Operation(summary = "修改设备管理", description = "修改设备管理")
    @SysLog("修改设备管理" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('equipment_equipmentmanage_edit')" )
    public R updateById(@RequestBody EquipmentManage equipmentManage) {
        return R.ok(equipmentManageService.updateById(equipmentManage));
    }

    /**
     * 通过id删除设备管理
     * @param id id
     * @return R
     */
    @Operation(summary = "通过id删除设备管理", description = "通过id删除设备管理")
    @SysLog("通过id删除设备管理" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('equipment_equipmentmanage_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(equipmentManageService.removeById(id));
    }

	/**
	 * 通过ids删除设备管理
	 * @param ids ids
	 * @return R
	 */
	@Operation(summary = "通过ids删除设备管理", description = "通过ids删除设备管理")
	@SysLog("通过ids删除设备管理" )
	@DeleteMapping("/batchRemove" )
	@PreAuthorize("@pms.hasPermission('equipment_equipmentmanage_del')" )
	public R removeByIds(@RequestBody Long[] ids) {
		System.out.println(ids);
		List idList=new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			idList.add(ids[i]);
		}
		return R.ok(equipmentManageService.removeByIds(idList));
	}

	/**
	 * 通过ids启用设备
	 * @param ids ids
	 * @return R
	 */
	@Operation(summary = "通过ids启用设备", description = "通过ids启用设备")
	@SysLog("通过ids启用设备" )
	@PutMapping("/startEquipmentByIds" )
	@PreAuthorize("@pms.hasPermission('equipment_equipmentmanage_edit')" )
	public R startEquipmentByIds(@RequestBody Long[] ids) {
		System.out.println(ids);
		List idList=new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			EquipmentManage equipmentManage = equipmentManageService.getById(ids[i]);
			equipmentManage.setEquipmentStatus("1");
			equipmentManage.setStartTime(LocalDateTime.now());
			equipmentManageService.updateById(equipmentManage);
		}
		return R.ok();
	}

	/**
	 * 通过ids停止设备
	 * @param ids ids
	 * @return R
	 */
	@Operation(summary = "通过ids停止设备", description = "通过ids停止设备")
	@SysLog("通过ids停止设备" )
	@PutMapping("/stopEquipmentByIds" )
	@PreAuthorize("@pms.hasPermission('equipment_equipmentmanage_edit')" )
	public R stopEquipmentByIds(@RequestBody Long[] ids) {
		System.out.println(ids);
		List idList=new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			EquipmentManage equipmentManage = equipmentManageService.getById(ids[i]);
			equipmentManage.setEquipmentStatus("-2");
			equipmentManage.setStopTime(LocalDateTime.now());
			equipmentManageService.updateById(equipmentManage);
		}
		return R.ok();
	}
}
