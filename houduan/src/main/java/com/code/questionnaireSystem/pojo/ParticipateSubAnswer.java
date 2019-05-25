package com.code.questionnaireSystem.pojo;

import lombok.Data;

/**
 * 每个参与者的副标题实体
 * 
 * @author 皮艳萍
 *
 */
@Data
public class ParticipateSubAnswer {
	private String subQuestionId;
	private String optionId;
	private String answerText;
}
