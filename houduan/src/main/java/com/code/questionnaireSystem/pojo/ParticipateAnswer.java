package com.code.questionnaireSystem.pojo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

/**
 * 每个参与者选择的答案对应的实体
 * 
 * @author 皮艳萍
 *
 */
@Data
public class ParticipateAnswer {
	private String questionId;
	private Set<String> subQuestIds;
	private Map<String, List<String>> optionMap;
	private List<ParticipateSubAnswer> participateSubAnswers;

}
