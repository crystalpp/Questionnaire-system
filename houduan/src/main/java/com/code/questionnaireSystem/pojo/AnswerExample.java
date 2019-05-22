package com.code.questionnaireSystem.pojo;

import java.util.ArrayList;
import java.util.List;

public class AnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnswerExample() {
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

        public Criteria andAnswerIdIsNull() {
            addCriterion("answer_id is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIsNotNull() {
            addCriterion("answer_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerIdEqualTo(String value) {
            addCriterion("answer_id =", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotEqualTo(String value) {
            addCriterion("answer_id <>", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThan(String value) {
            addCriterion("answer_id >", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdGreaterThanOrEqualTo(String value) {
            addCriterion("answer_id >=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThan(String value) {
            addCriterion("answer_id <", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLessThanOrEqualTo(String value) {
            addCriterion("answer_id <=", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdLike(String value) {
            addCriterion("answer_id like", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotLike(String value) {
            addCriterion("answer_id not like", value, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdIn(List<String> values) {
            addCriterion("answer_id in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotIn(List<String> values) {
            addCriterion("answer_id not in", values, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdBetween(String value1, String value2) {
            addCriterion("answer_id between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andAnswerIdNotBetween(String value1, String value2) {
            addCriterion("answer_id not between", value1, value2, "answerId");
            return (Criteria) this;
        }

        public Criteria andSurverIdIsNull() {
            addCriterion("surver_id is null");
            return (Criteria) this;
        }

        public Criteria andSurverIdIsNotNull() {
            addCriterion("surver_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurverIdEqualTo(String value) {
            addCriterion("surver_id =", value, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdNotEqualTo(String value) {
            addCriterion("surver_id <>", value, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdGreaterThan(String value) {
            addCriterion("surver_id >", value, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdGreaterThanOrEqualTo(String value) {
            addCriterion("surver_id >=", value, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdLessThan(String value) {
            addCriterion("surver_id <", value, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdLessThanOrEqualTo(String value) {
            addCriterion("surver_id <=", value, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdLike(String value) {
            addCriterion("surver_id like", value, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdNotLike(String value) {
            addCriterion("surver_id not like", value, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdIn(List<String> values) {
            addCriterion("surver_id in", values, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdNotIn(List<String> values) {
            addCriterion("surver_id not in", values, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdBetween(String value1, String value2) {
            addCriterion("surver_id between", value1, value2, "surverId");
            return (Criteria) this;
        }

        public Criteria andSurverIdNotBetween(String value1, String value2) {
            addCriterion("surver_id not between", value1, value2, "surverId");
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

        public Criteria andSubquestionIdIsNull() {
            addCriterion("subQuestion_id is null");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdIsNotNull() {
            addCriterion("subQuestion_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdEqualTo(String value) {
            addCriterion("subQuestion_id =", value, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdNotEqualTo(String value) {
            addCriterion("subQuestion_id <>", value, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdGreaterThan(String value) {
            addCriterion("subQuestion_id >", value, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdGreaterThanOrEqualTo(String value) {
            addCriterion("subQuestion_id >=", value, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdLessThan(String value) {
            addCriterion("subQuestion_id <", value, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdLessThanOrEqualTo(String value) {
            addCriterion("subQuestion_id <=", value, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdLike(String value) {
            addCriterion("subQuestion_id like", value, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdNotLike(String value) {
            addCriterion("subQuestion_id not like", value, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdIn(List<String> values) {
            addCriterion("subQuestion_id in", values, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdNotIn(List<String> values) {
            addCriterion("subQuestion_id not in", values, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdBetween(String value1, String value2) {
            addCriterion("subQuestion_id between", value1, value2, "subquestionId");
            return (Criteria) this;
        }

        public Criteria andSubquestionIdNotBetween(String value1, String value2) {
            addCriterion("subQuestion_id not between", value1, value2, "subquestionId");
            return (Criteria) this;
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

        public Criteria andParticipateIdIsNull() {
            addCriterion("participate_id is null");
            return (Criteria) this;
        }

        public Criteria andParticipateIdIsNotNull() {
            addCriterion("participate_id is not null");
            return (Criteria) this;
        }

        public Criteria andParticipateIdEqualTo(String value) {
            addCriterion("participate_id =", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdNotEqualTo(String value) {
            addCriterion("participate_id <>", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdGreaterThan(String value) {
            addCriterion("participate_id >", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdGreaterThanOrEqualTo(String value) {
            addCriterion("participate_id >=", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdLessThan(String value) {
            addCriterion("participate_id <", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdLessThanOrEqualTo(String value) {
            addCriterion("participate_id <=", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdLike(String value) {
            addCriterion("participate_id like", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdNotLike(String value) {
            addCriterion("participate_id not like", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdIn(List<String> values) {
            addCriterion("participate_id in", values, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdNotIn(List<String> values) {
            addCriterion("participate_id not in", values, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdBetween(String value1, String value2) {
            addCriterion("participate_id between", value1, value2, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdNotBetween(String value1, String value2) {
            addCriterion("participate_id not between", value1, value2, "participateId");
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