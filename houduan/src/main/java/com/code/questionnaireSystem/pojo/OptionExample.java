package com.code.questionnaireSystem.pojo;

import java.util.ArrayList;
import java.util.List;

public class OptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OptionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOptionIdIsNull() {
            addCriterion("option_id is null");
            return (Criteria) this;
        }

        public Criteria andOptionIdIsNotNull() {
            addCriterion("option_id is not null");
            return (Criteria) this;
        }

        public Criteria andOptionIdEqualTo(String value) {
            addCriterion("option_id =", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotEqualTo(String value) {
            addCriterion("option_id <>", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdGreaterThan(String value) {
            addCriterion("option_id >", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdGreaterThanOrEqualTo(String value) {
            addCriterion("option_id >=", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdLessThan(String value) {
            addCriterion("option_id <", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdLessThanOrEqualTo(String value) {
            addCriterion("option_id <=", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdLike(String value) {
            addCriterion("option_id like", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotLike(String value) {
            addCriterion("option_id not like", value, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdIn(List<String> values) {
            addCriterion("option_id in", values, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotIn(List<String> values) {
            addCriterion("option_id not in", values, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdBetween(String value1, String value2) {
            addCriterion("option_id between", value1, value2, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionIdNotBetween(String value1, String value2) {
            addCriterion("option_id not between", value1, value2, "optionId");
            return (Criteria) this;
        }

        public Criteria andOptionContentIsNull() {
            addCriterion("option_content is null");
            return (Criteria) this;
        }

        public Criteria andOptionContentIsNotNull() {
            addCriterion("option_content is not null");
            return (Criteria) this;
        }

        public Criteria andOptionContentEqualTo(String value) {
            addCriterion("option_content =", value, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentNotEqualTo(String value) {
            addCriterion("option_content <>", value, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentGreaterThan(String value) {
            addCriterion("option_content >", value, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentGreaterThanOrEqualTo(String value) {
            addCriterion("option_content >=", value, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentLessThan(String value) {
            addCriterion("option_content <", value, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentLessThanOrEqualTo(String value) {
            addCriterion("option_content <=", value, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentLike(String value) {
            addCriterion("option_content like", value, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentNotLike(String value) {
            addCriterion("option_content not like", value, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentIn(List<String> values) {
            addCriterion("option_content in", values, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentNotIn(List<String> values) {
            addCriterion("option_content not in", values, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentBetween(String value1, String value2) {
            addCriterion("option_content between", value1, value2, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionContentNotBetween(String value1, String value2) {
            addCriterion("option_content not between", value1, value2, "optionContent");
            return (Criteria) this;
        }

        public Criteria andOptionScoreIsNull() {
            addCriterion("option_score is null");
            return (Criteria) this;
        }

        public Criteria andOptionScoreIsNotNull() {
            addCriterion("option_score is not null");
            return (Criteria) this;
        }

        public Criteria andOptionScoreEqualTo(String value) {
            addCriterion("option_score =", value, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreNotEqualTo(String value) {
            addCriterion("option_score <>", value, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreGreaterThan(String value) {
            addCriterion("option_score >", value, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreGreaterThanOrEqualTo(String value) {
            addCriterion("option_score >=", value, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreLessThan(String value) {
            addCriterion("option_score <", value, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreLessThanOrEqualTo(String value) {
            addCriterion("option_score <=", value, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreLike(String value) {
            addCriterion("option_score like", value, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreNotLike(String value) {
            addCriterion("option_score not like", value, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreIn(List<String> values) {
            addCriterion("option_score in", values, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreNotIn(List<String> values) {
            addCriterion("option_score not in", values, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreBetween(String value1, String value2) {
            addCriterion("option_score between", value1, value2, "optionScore");
            return (Criteria) this;
        }

        public Criteria andOptionScoreNotBetween(String value1, String value2) {
            addCriterion("option_score not between", value1, value2, "optionScore");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNull() {
            addCriterion("question_id is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIsNotNull() {
            addCriterion("question_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionIdEqualTo(String value) {
            addCriterion("question_id =", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotEqualTo(String value) {
            addCriterion("question_id <>", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThan(String value) {
            addCriterion("question_id >", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdGreaterThanOrEqualTo(String value) {
            addCriterion("question_id >=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThan(String value) {
            addCriterion("question_id <", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLessThanOrEqualTo(String value) {
            addCriterion("question_id <=", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdLike(String value) {
            addCriterion("question_id like", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotLike(String value) {
            addCriterion("question_id not like", value, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdIn(List<String> values) {
            addCriterion("question_id in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotIn(List<String> values) {
            addCriterion("question_id not in", values, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdBetween(String value1, String value2) {
            addCriterion("question_id between", value1, value2, "questionId");
            return (Criteria) this;
        }

        public Criteria andQuestionIdNotBetween(String value1, String value2) {
            addCriterion("question_id not between", value1, value2, "questionId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}