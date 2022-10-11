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

package com.pig4cloud.pig.ywzfjd.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.ywzfjd.entity.YwZfjd;
import com.pig4cloud.pig.ywzfjd.service.YwZfjdService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;


/**
 * zfjd 表
 *
 * @author pig code generator
 * @date 2022-10-10 11:15:09
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/ywzfjd")
@Tag(name = "zfjd 表管理")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class YwZfjdController {

	private final YwZfjdService ywZfjdService;

	/**
	 * 分页查询
	 *
	 * @param page   分页对象
	 * @param ywZfjd zfjd 表
	 * @return
	 */
	@Operation(summary = "分页查询", description = "分页查询")
	@GetMapping("/page")
	@PreAuthorize("@pms.hasPermission('ywzfjd_ywzfjd_get')")
	public R getYwZfjdPage(Page page, YwZfjd ywZfjd) {
		return R.ok(ywZfjdService.page(page, Wrappers.query(ywZfjd)));
	}


	/**
	 * 通过id查询zfjd 表
	 *
	 * @param id id
	 * @return R
	 */
	@Operation(summary = "通过id查询", description = "通过id查询")
	@GetMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('ywzfjd_ywzfjd_get')")
	public R getById(@PathVariable("id") Long id) {
		return R.ok(ywZfjdService.getById(id));
	}

	/**
	 * 新增zfjd 表
	 *
	 * @param ywZfjd zfjd 表
	 * @return R
	 */
	@Operation(summary = "新增zfjd 表", description = "新增zfjd 表")
	@SysLog("新增zfjd 表")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('ywzfjd_ywzfjd_add')")
	public R save(@RequestBody YwZfjd ywZfjd) {
		return R.ok(ywZfjdService.save(ywZfjd));
	}

	/**
	 * 修改zfjd 表
	 *
	 * @param ywZfjd zfjd 表
	 * @return R
	 */
	@Operation(summary = "修改zfjd 表", description = "修改zfjd 表")
	@SysLog("修改zfjd 表")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('ywzfjd_ywzfjd_edit')")
	public R updateById(@RequestBody YwZfjd ywZfjd) {
		return R.ok(ywZfjdService.updateById(ywZfjd));
	}

	/**
	 * 通过id删除zfjd 表
	 *
	 * @param id id
	 * @return R
	 */
	@Operation(summary = "通过id删除zfjd 表", description = "通过id删除zfjd 表")
	@SysLog("通过id删除zfjd 表")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('ywzfjd_ywzfjd_del')")
	public R removeById(@PathVariable Long id) {
		return R.ok(ywZfjdService.removeById(id));
	}

}
