package com.code.questionnaireSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.service.SurverService;
import com.code.questionnaireSystem.utils.QrCodeUtils;
import com.code.questionnaireSystem.utils.Result;
import com.code.questionnaireSystem.utils.ResultCode;

/**
 * 问卷controller层
 * 
 * @author 皮艳萍
 *
 */
@RestController
@RequestMapping("/surver")
public class SurverController {
	@Autowired
	private SurverService surverService;

	/**
	 * 新增问卷
	 * 
	 * @param userId
	 * @return
	 */
	@PostMapping("/add")
	public Result insert(String userId, String surverTypeId) {
		return surverService.insert(userId, surverTypeId);
	}

	/**
	 * 根据问卷id更新问卷title,desription
	 * 
	 * @param title
	 * @param description
	 * @param id
	 * @return
	 */
	@PostMapping("/update")
	public Result update(String title, String description, String id) {
		return surverService.update(title, description, id);
	}

	/**
	 * 问卷发布时，更新问卷的填写截止时间和是否限制同一ip填写多次
	 */
	@PostMapping("/updatePublish")
	public Result updateEndTime(String surverId, String EndTime, int limitIP) {
		return surverService.updateEndTime(surverId, EndTime, limitIP);
	}

	/**
	 * 根据问卷id查询该问卷的信息
	 * 
	 * @param surverId
	 * @return
	 */
	@GetMapping("/search")
	public Result search(String surverId) {
		return surverService.search(surverId);
	}

	/**
	 * 根据userid查询该用户所创建的所有问卷
	 * 
	 * @param userId
	 * @return
	 */
	@GetMapping("/seachByUserId")
	public Result seachByUserId(String userId) {
		return surverService.seachByUserId(userId);
	}

	/**
	 * 根据问卷id 删除该问卷
	 * 
	 * @param surverId
	 * @return
	 */
	@PostMapping("/deleteById")
	public Result deleteById(String surverId) {
		return surverService.deleteById(surverId);
	}

	@GetMapping("/getQRimage")
	public Result productcode(String url) {
		String imagePath = QrCodeUtils.zxingCodeCreate(url,
				"/home/www/Questionnaire-system/houduan/src/main/resources/static/QR/", 500,
				"/home/www/Questionnaire-system/material/img/logo.jpg");
		if (imagePath != null) {
			return Result.success(imagePath);
		} else {
			return Result.failure(ResultCode.FAIL);
		}
	}

	/**
	 * 根据问卷类型筛选问卷
	 * 
	 * @param surverTypeId
	 * @return
	 */

	@GetMapping("/selectSurvers")
	public Result selectSurvers(String surverTypeId, String surverTitle) {
		return surverService.selectSurvers(surverTypeId, surverTitle);
	}

	/**
	 * 获取所有的模板问卷数据 可以传入
	 * 
	 * @param surverTypeId
	 * @return
	 */
	@GetMapping("/getTemplate")
	public Result getTemplate(String surverTypeId) {
		return surverService.getTemplate(surverTypeId);
	}

	/**
	 * 修改问卷的问卷类型
	 * 
	 * @param surverId
	 *            问卷id
	 * @param surverTypeId
	 *            问卷类型id
	 * @return
	 */
	@PostMapping("/updateSurverType")
	public Result updateSurverType(String surverId, String surverTypeId) {
		return surverService.updateSurverType(surverId, surverTypeId);
	}

	/**
	 * 用户填写完问卷后，回收数量增加
	 */
	@PostMapping("/updateRecoverNum")
	public Result updateRecoverNum(String surverId) {
		return surverService.updateRecoverNum(surverId);
	}

	@PostMapping("/creatByTemplate")
	public Result creatByTemplate(String templateSurverId, String userId) {
		return surverService.creatByTemplate(templateSurverId, userId);
	}

	@PostMapping("/updateQRNum")
	public Result updateQRNum(String surverId, String QRNum) {
		return surverService.updateQRNum(surverId, QRNum);
	}
}
