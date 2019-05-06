package com.code.questionnaireSystem.pojo;

import java.util.ArrayList;
import java.util.List;

public class SelectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SelectExample() {
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

        public Criteria andSelectIdIsNull() {
            addCriterion("select_id is null");
            return (Criteria) this;
        }

        public Criteria andSelectIdIsNotNull() {
            addCriterion("select_id is not null");
            return (Criteria) this;
        }

        public Criteria andSelectIdEqualTo(Integer value) {
            addCriterion("select_id =", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdNotEqualTo(Integer value) {
            addCriterion("select_id <>", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdGreaterThan(Integer value) {
            addCriterion("select_id >", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("select_id >=", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdLessThan(Integer value) {
            addCriterion("select_id <", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdLessThanOrEqualTo(Integer value) {
            addCriterion("select_id <=", value, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdIn(List<Integer> values) {
            addCriterion("select_id in", values, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdNotIn(List<Integer> values) {
            addCriterion("select_id not in", values, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdBetween(Integer value1, Integer value2) {
            addCriterion("select_id between", value1, value2, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("select_id not between", value1, value2, "selectId");
            return (Criteria) this;
        }

        public Criteria andSelectContentIsNull() {
            addCriterion("select_content is null");
            return (Criteria) this;
        }

        public Criteria andSelectContentIsNotNull() {
            addCriterion("select_content is not null");
            return (Criteria) this;
        }

        public Criteria andSelectContentEqualTo(String value) {
            addCriterion("select_content =", value, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentNotEqualTo(String value) {
            addCriterion("select_content <>", value, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentGreaterThan(String value) {
            addCriterion("select_content >", value, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentGreaterThanOrEqualTo(String value) {
            addCriterion("select_content >=", value, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentLessThan(String value) {
            addCriterion("select_content <", value, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentLessThanOrEqualTo(String value) {
            addCriterion("select_content <=", value, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentLike(String value) {
            addCriterion("select_content like", value, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentNotLike(String value) {
            addCriterion("select_content not like", value, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentIn(List<String> values) {
            addCriterion("select_content in", values, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentNotIn(List<String> values) {
            addCriterion("select_content not in", values, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentBetween(String value1, String value2) {
            addCriterion("select_content between", value1, value2, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectContentNotBetween(String value1, String value2) {
            addCriterion("select_content not between", value1, value2, "selectContent");
            return (Criteria) this;
        }

        public Criteria andSelectScoreIsNull() {
            addCriterion("select_score is null");
            return (Criteria) this;
        }

        public Criteria andSelectScoreIsNotNull() {
            addCriterion("select_score is not null");
            return (Criteria) this;
        }

        public Criteria andSelectScoreEqualTo(String value) {
            addCriterion("select_score =", value, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreNotEqualTo(String value) {
            addCriterion("select_score <>", value, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreGreaterThan(String value) {
            addCriterion("select_score >", value, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreGreaterThanOrEqualTo(String value) {
            addCriterion("select_score >=", value, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreLessThan(String value) {
            addCriterion("select_score <", value, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreLessThanOrEqualTo(String value) {
            addCriterion("select_score <=", value, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreLike(String value) {
            addCriterion("select_score like", value, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreNotLike(String value) {
            addCriterion("select_score not like", value, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreIn(List<String> values) {
            addCriterion("select_score in", values, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreNotIn(List<String> values) {
            addCriterion("select_score not in", values, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreBetween(String value1, String value2) {
            addCriterion("select_score between", value1, value2, "selectScore");
            return (Criteria) this;
        }

        public Criteria andSelectScoreNotBetween(String value1, String value2) {
            addCriterion("select_score not between", value1, value2, "selectScore");
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