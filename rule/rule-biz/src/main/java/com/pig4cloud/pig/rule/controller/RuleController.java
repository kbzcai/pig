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

package com.pig4cloud.pig.rule.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pig4cloud.pig.common.core.util.R;
import com.pig4cloud.pig.common.log.annotation.SysLog;
import com.pig4cloud.pig.rule.entity.Rule;
import com.pig4cloud.pig.rule.service.RuleService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * 规则定义
 *
 * @author pig code generator
 * @date 2022-10-11 14:57:46
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/rule" )
@Tag(name = "规则定义管理")
@SecurityRequirement(name = HttpHeaders.AUTHORIZATION)
public class RuleController {

    private final  RuleService ruleService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param rule 规则定义
     * @return
     */
    @Operation(summary = "分页查询", description = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('rule_rule_get')" )
    public R getRulePage(Page page, Rule rule) {
		QueryWrapper wrapper=new QueryWrapper();
		if (!rule.getRuleName().equals("")){
			wrapper.like("rule_name",rule.getRuleName());
		}
        return R.ok(ruleService.page(page, wrapper));
    }


    /**
     * 通过id查询规则定义
     * @param id id
     * @return R
     */
    @Operation(summary = "通过id查询", description = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('rule_rule_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(ruleService.getById(id));
    }

    /**
     * 新增规则定义
     * @param rule 规则定义
     * @return R
     */
    @Operation(summary = "新增规则定义", description = "新增规则定义")
    @SysLog("新增规则定义" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('rule_rule_add')" )
    public R save(@RequestBody Rule rule) {
    	if (rule.getRuleStatus().equals("1")){
    		rule.setStartTime(LocalDateTime.now());
		}
        return R.ok(ruleService.save(rule));
    }

    /**
     * 修改规则定义
     * @param rule 规则定义
     * @return R
     */
    @Operation(summary = "修改规则定义", description = "修改规则定义")
    @SysLog("修改规则定义" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('rule_rule_edit')" )
    public R updateById(@RequestBody Rule rule) {
    	if (rule.getRuleStatus().equals("1")){
    		rule.setStartTime(LocalDateTime.now());
		}else {
			rule.setStopTime(LocalDateTime.now());
		}

        return R.ok(ruleService.updateById(rule));
    }

    /**
     * 通过id删除规则定义
     * @param id id
     * @return R
     */
    @Operation(summary = "通过id删除规则定义", description = "通过id删除规则定义")
    @SysLog("通过id删除规则定义" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('rule_rule_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(ruleService.removeById(id));
    }

	/**
	 * 通过ids删除规则定义
	 * @param ids ids
	 * @return R
	 */
	@Operation(summary = "通过idS删除规则定义", description = "通过ids删除规则定义")
	@SysLog("通过ids删除规则定义" )
	@DeleteMapping("batchRemove" )
	@PreAuthorize("@pms.hasPermission('rule_rule_del')" )
	public R removeById(@RequestBody Long[] ids) {
		System.out.println(ids);
		List idList=new ArrayList();
		for (int i = 0; i < ids.length; i++) {
			idList.add(ids[i]);
		}
		return R.ok(ruleService.removeByIds(idList));
	}

}
