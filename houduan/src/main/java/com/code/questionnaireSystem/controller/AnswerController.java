package com.code.questionnaireSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.code.questionnaireSystem.service.AnswerService;
import com.code.questionnaireSystem.utils.Result;

@RestController
@RequestMapping("/answer")
public class AnswerController {
	@Autowired
	private AnswerService answerService;

	@PostMapping("/add")
	public Result add(String surverId, String questionId,
			@RequestParam(name = "subQuestionId", required = false) String subQuestionId,
			@RequestParam(name = "optionId", required = false) String optionId,
			@RequestParam(name = "answerText", required = false) String answerText, String participateId) {
		return answerService.add(surverId, questionId, subQuestionId, optionId, answerText, participateId);
	}

	@GetMapping("/getAnswersBySurverId")
	public Result getAnswersBySurverId(String surverId) {
		return answerService.getAnswersBySurverId(surverId);
	}

	/**
	 * 根据参与者id,和问卷id查询答题情况，得到每个答题者的情况
	 * 
	 * @param participateId
	 * @param surverId
	 * @return
	 */
	@GetMapping("/getAnswersByParticipateId")
	public Result getAnswersByParticipateId(String participateId, String surverId) {
		return answerService.getAnswersByParticipateId(participateId, surverId);
	}

	/**
	 * 根据问卷id统计问卷类型为文字型的问卷的数据
	 * 
	 * @param surverId
	 * @return
	 */
	@GetMapping("/staticAnswerText")
	public Result staticAnswerText(String surverId) {
		return answerService.staticAnswerText(surverId);
	}

	/**
	 * 统计每份问卷的回收数量
	 * 
	 * @param surverId
	 * @return
	 */
	@GetMapping("/countAnswerNum")
	public Result countAnswerNum(String surverId) {
		return answerService.countAnswerNum(surverId);
	}

	/**
	 * 删除某个参与者的答案
	 * 
	 * @param participateId
	 * @return
	 */
	@PostMapping("deleteAnswer")
	public Result deleteAnswer(String participateId, String surverId) {
		return answerService.deleteAnswer(participateId, surverId);
	}
}
