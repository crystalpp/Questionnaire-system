package com.code.questionnaireSystem.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionExample() {
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

        public Criteria andQuestionNameIsNull() {
            addCriterion("question_name is null");
            return (Criteria) this;
        }

        public Criteria andQuestionNameIsNotNull() {
            addCriterion("question_name is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionNameEqualTo(String value) {
            addCriterion("question_name =", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameNotEqualTo(String value) {
            addCriterion("question_name <>", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameGreaterThan(String value) {
            addCriterion("question_name >", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameGreaterThanOrEqualTo(String value) {
            addCriterion("question_name >=", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameLessThan(String value) {
            addCriterion("question_name <", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameLessThanOrEqualTo(String value) {
            addCriterion("question_name <=", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameLike(String value) {
            addCriterion("question_name like", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameNotLike(String value) {
            addCriterion("question_name not like", value, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameIn(List<String> values) {
            addCriterion("question_name in", values, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameNotIn(List<String> values) {
            addCriterion("question_name not in", values, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameBetween(String value1, String value2) {
            addCriterion("question_name between", value1, value2, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionNameNotBetween(String value1, String value2) {
            addCriterion("question_name not between", value1, value2, "questionName");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionIsNull() {
            addCriterion("question_direction is null");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionIsNotNull() {
            addCriterion("question_direction is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionEqualTo(String value) {
            addCriterion("question_direction =", value, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionNotEqualTo(String value) {
            addCriterion("question_direction <>", value, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionGreaterThan(String value) {
            addCriterion("question_direction >", value, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionGreaterThanOrEqualTo(String value) {
            addCriterion("question_direction >=", value, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionLessThan(String value) {
            addCriterion("question_direction <", value, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionLessThanOrEqualTo(String value) {
            addCriterion("question_direction <=", value, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionLike(String value) {
            addCriterion("question_direction like", value, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionNotLike(String value) {
            addCriterion("question_direction not like", value, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionIn(List<String> values) {
            addCriterion("question_direction in", values, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionNotIn(List<String> values) {
            addCriterion("question_direction not in", values, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionBetween(String value1, String value2) {
            addCriterion("question_direction between", value1, value2, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionDirectionNotBetween(String value1, String value2) {
            addCriterion("question_direction not between", value1, value2, "questionDirection");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedIsNull() {
            addCriterion("question_need is null");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedIsNotNull() {
            addCriterion("question_need is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedEqualTo(String value) {
            addCriterion("question_need =", value, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedNotEqualTo(String value) {
            addCriterion("question_need <>", value, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedGreaterThan(String value) {
            addCriterion("question_need >", value, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedGreaterThanOrEqualTo(String value) {
            addCriterion("question_need >=", value, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedLessThan(String value) {
            addCriterion("question_need <", value, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedLessThanOrEqualTo(String value) {
            addCriterion("question_need <=", value, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedLike(String value) {
            addCriterion("question_need like", value, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedNotLike(String value) {
            addCriterion("question_need not like", value, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedIn(List<String> values) {
            addCriterion("question_need in", values, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedNotIn(List<String> values) {
            addCriterion("question_need not in", values, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedBetween(String value1, String value2) {
            addCriterion("question_need between", value1, value2, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuestionNeedNotBetween(String value1, String value2) {
            addCriterion("question_need not between", value1, value2, "questionNeed");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdIsNull() {
            addCriterion("queType_id is null");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdIsNotNull() {
            addCriterion("queType_id is not null");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdEqualTo(String value) {
            addCriterion("queType_id =", value, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdNotEqualTo(String value) {
            addCriterion("queType_id <>", value, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdGreaterThan(String value) {
            addCriterion("queType_id >", value, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("queType_id >=", value, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdLessThan(String value) {
            addCriterion("queType_id <", value, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdLessThanOrEqualTo(String value) {
            addCriterion("queType_id <=", value, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdLike(String value) {
            addCriterion("queType_id like", value, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdNotLike(String value) {
            addCriterion("queType_id not like", value, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdIn(List<String> values) {
            addCriterion("queType_id in", values, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdNotIn(List<String> values) {
            addCriterion("queType_id not in", values, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdBetween(String value1, String value2) {
            addCriterion("queType_id between", value1, value2, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuetypeIdNotBetween(String value1, String value2) {
            addCriterion("queType_id not between", value1, value2, "quetypeId");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeIsNull() {
            addCriterion("question_creatTime is null");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeIsNotNull() {
            addCriterion("question_creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeEqualTo(Date value) {
            addCriterion("question_creatTime =", value, "questionCreattime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeNotEqualTo(Date value) {
            addCriterion("question_creatTime <>", value, "questionCreattime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeGreaterThan(Date value) {
            addCriterion("question_creatTime >", value, "questionCreattime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("question_creatTime >=", value, "questionCreattime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeLessThan(Date value) {
            addCriterion("question_creatTime <", value, "questionCreattime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("question_creatTime <=", value, "questionCreattime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeIn(List<Date> values) {
            addCriterion("question_creatTime in", values, "questionCreattime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeNotIn(List<Date> values) {
            addCriterion("question_creatTime not in", values, "questionCreattime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeBetween(Date value1, Date value2) {
            addCriterion("question_creatTime between", value1, value2, "questionCreattime");
            return (Criteria) this;
        }

        public Criteria andQuestionCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("question_creatTime not between", value1, value2, "questionCreattime");
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