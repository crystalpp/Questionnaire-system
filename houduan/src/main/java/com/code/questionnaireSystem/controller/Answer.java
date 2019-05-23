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
public class Answer {
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
	 * 根据参与者id,查询答题情况，得到每个答题者的情况
	 * 
	 * @param participateId
	 * @return
	 */
	@GetMapping("/getAnswersByParticipateId")
	public Result getAnswersByParticipateId(String participateId) {
		return answerService.getAnswersByParticipateId(participateId);
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

}
