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

package com.pig4cloud.pig.zfjd.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.zfjd.entity.Zfjd;
import com.pig4cloud.pig.zfjd.service.ZfjdService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;


/**
 * zfjd
 *
 * @author cyj
 * @date 2022-09-29 16:27:30
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/zfjd" )
@Tag(name = "zfjd管理")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class ZfjdController {

    private final  ZfjdService zfjdService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param zfjd zfjd
     * @return
     */
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('zfjd_zfjd_get')" )
    public R getZfjdPage(Page page, Zfjd zfjd) {
		System.out.println(zfjd);
		QueryWrapper<Zfjd> wrapper = new QueryWrapper();
		Zfjd zfjd1=new Zfjd();
		if (!zfjd.getCaseNo().equals("")){
			wrapper.like("case_no",zfjd.getCaseNo());
//			zfjd1.setIllegalAction(zfjd.getIllegalAction());
		}
		if (!zfjd.getIllegalAction().equals("")){
			wrapper.eq("illegal_action",zfjd.getIllegalAction());
//			zfjd1.setIllegalAction(zfjd.getIllegalAction());
		}
		if (!zfjd.getStatus().equals("")){
//			zfjd1.setStatus(zfjd.getStatus());
			wrapper.eq("status",zfjd.getStatus());
		}
//		if (!zfjd.getId().equals("")){
////			zfjd1.setStatus(zfjd.getStatus());
//			wrapper.like("id",zfjd.getId());
//		}
		return R.ok(zfjdService.page(page, wrapper));
//		return R.ok(zfjdService.page(page, Wrappers.query(zfjd1)));
    }


    /**
     * 通过id查询zfjd
     * @param id id
     * @return R
     */
    @Operation(summary = "通过id查询", description = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('zfjd_zfjd_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(zfjdService.getById(id));
    }

    /**
     * 新增zfjd
     * @param zfjd zfjd
     * @return R
     */
    @Operation(summary = "新增zfjd", description = "新增zfjd")
    @SysLog("新增zfjd" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('zfjd_zfjd_add')" )
    public R save(@RequestBody Zfjd zfjd) {
        return R.ok(zfjdService.save(zfjd));
    }

    /**
     * 修改zfjd
     * @param zfjd zfjd
     * @return R
     */
    @Operation(summary = "修改zfjd", description = "修改zfjd")
    @SysLog("修改zfjd" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('zfjd_zfjd_edit')" )
    public R updateById(@RequestBody Zfjd zfjd) {
    	if(zfjd.getIllegalAction().equals("")){
    		zfjd.setStatus("-1");
		}else{
    		zfjd.setStatus("2");
		}
        return R.ok(zfjdService.updateById(zfjd));
    }

    /**
     * 通过id删除zfjd
     * @param id id
     * @return R
     */
    @Operation(summary = "通过id删除zfjd", description = "通过id删除zfjd")
    @SysLog("通过id删除zfjd" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('zfjd_zfjd_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(zfjdService.removeById(id));
    }

}
