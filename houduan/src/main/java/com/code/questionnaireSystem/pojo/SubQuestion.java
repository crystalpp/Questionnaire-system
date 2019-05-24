package com.code.questionnaireSystem.pojo;

import java.util.List;

import lombok.Data;

@Data
public class SubQuestion {
	private String subQuestion_id;
	private String sub_QuestionName;
	private List<OptionNum> optionNums;

}
