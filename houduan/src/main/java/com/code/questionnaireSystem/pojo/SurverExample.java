package com.code.questionnaireSystem.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SurverExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SurverExample() {
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

        public Criteria andSurverTitleIsNull() {
            addCriterion("surver_title is null");
            return (Criteria) this;
        }

        public Criteria andSurverTitleIsNotNull() {
            addCriterion("surver_title is not null");
            return (Criteria) this;
        }

        public Criteria andSurverTitleEqualTo(String value) {
            addCriterion("surver_title =", value, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleNotEqualTo(String value) {
            addCriterion("surver_title <>", value, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleGreaterThan(String value) {
            addCriterion("surver_title >", value, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleGreaterThanOrEqualTo(String value) {
            addCriterion("surver_title >=", value, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleLessThan(String value) {
            addCriterion("surver_title <", value, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleLessThanOrEqualTo(String value) {
            addCriterion("surver_title <=", value, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleLike(String value) {
            addCriterion("surver_title like", value, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleNotLike(String value) {
            addCriterion("surver_title not like", value, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleIn(List<String> values) {
            addCriterion("surver_title in", values, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleNotIn(List<String> values) {
            addCriterion("surver_title not in", values, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleBetween(String value1, String value2) {
            addCriterion("surver_title between", value1, value2, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverTitleNotBetween(String value1, String value2) {
            addCriterion("surver_title not between", value1, value2, "surverTitle");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionIsNull() {
            addCriterion("surver_description is null");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionIsNotNull() {
            addCriterion("surver_description is not null");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionEqualTo(String value) {
            addCriterion("surver_description =", value, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionNotEqualTo(String value) {
            addCriterion("surver_description <>", value, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionGreaterThan(String value) {
            addCriterion("surver_description >", value, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("surver_description >=", value, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionLessThan(String value) {
            addCriterion("surver_description <", value, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionLessThanOrEqualTo(String value) {
            addCriterion("surver_description <=", value, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionLike(String value) {
            addCriterion("surver_description like", value, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionNotLike(String value) {
            addCriterion("surver_description not like", value, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionIn(List<String> values) {
            addCriterion("surver_description in", values, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionNotIn(List<String> values) {
            addCriterion("surver_description not in", values, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionBetween(String value1, String value2) {
            addCriterion("surver_description between", value1, value2, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverDescriptionNotBetween(String value1, String value2) {
            addCriterion("surver_description not between", value1, value2, "surverDescription");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeIsNull() {
            addCriterion("surver_creatTime is null");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeIsNotNull() {
            addCriterion("surver_creatTime is not null");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeEqualTo(Date value) {
            addCriterion("surver_creatTime =", value, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeNotEqualTo(Date value) {
            addCriterion("surver_creatTime <>", value, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeGreaterThan(Date value) {
            addCriterion("surver_creatTime >", value, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("surver_creatTime >=", value, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeLessThan(Date value) {
            addCriterion("surver_creatTime <", value, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("surver_creatTime <=", value, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeIn(List<Date> values) {
            addCriterion("surver_creatTime in", values, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeNotIn(List<Date> values) {
            addCriterion("surver_creatTime not in", values, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeBetween(Date value1, Date value2) {
            addCriterion("surver_creatTime between", value1, value2, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("surver_creatTime not between", value1, value2, "surverCreattime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeIsNull() {
            addCriterion("surver_pulishStartTime is null");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeIsNotNull() {
            addCriterion("surver_pulishStartTime is not null");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeEqualTo(Date value) {
            addCriterion("surver_pulishStartTime =", value, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeNotEqualTo(Date value) {
            addCriterion("surver_pulishStartTime <>", value, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeGreaterThan(Date value) {
            addCriterion("surver_pulishStartTime >", value, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("surver_pulishStartTime >=", value, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeLessThan(Date value) {
            addCriterion("surver_pulishStartTime <", value, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeLessThanOrEqualTo(Date value) {
            addCriterion("surver_pulishStartTime <=", value, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeIn(List<Date> values) {
            addCriterion("surver_pulishStartTime in", values, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeNotIn(List<Date> values) {
            addCriterion("surver_pulishStartTime not in", values, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeBetween(Date value1, Date value2) {
            addCriterion("surver_pulishStartTime between", value1, value2, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverPulishstarttimeNotBetween(Date value1, Date value2) {
            addCriterion("surver_pulishStartTime not between", value1, value2, "surverPulishstarttime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeIsNull() {
            addCriterion("surver_endTime is null");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeIsNotNull() {
            addCriterion("surver_endTime is not null");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeEqualTo(Date value) {
            addCriterion("surver_endTime =", value, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeNotEqualTo(Date value) {
            addCriterion("surver_endTime <>", value, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeGreaterThan(Date value) {
            addCriterion("surver_endTime >", value, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("surver_endTime >=", value, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeLessThan(Date value) {
            addCriterion("surver_endTime <", value, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("surver_endTime <=", value, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeIn(List<Date> values) {
            addCriterion("surver_endTime in", values, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeNotIn(List<Date> values) {
            addCriterion("surver_endTime not in", values, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeBetween(Date value1, Date value2) {
            addCriterion("surver_endTime between", value1, value2, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("surver_endTime not between", value1, value2, "surverEndtime");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumIsNull() {
            addCriterion("surver_recoverNum is null");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumIsNotNull() {
            addCriterion("surver_recoverNum is not null");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumEqualTo(Integer value) {
            addCriterion("surver_recoverNum =", value, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumNotEqualTo(Integer value) {
            addCriterion("surver_recoverNum <>", value, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumGreaterThan(Integer value) {
            addCriterion("surver_recoverNum >", value, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumGreaterThanOrEqualTo(Integer value) {
            addCriterion("surver_recoverNum >=", value, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumLessThan(Integer value) {
            addCriterion("surver_recoverNum <", value, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumLessThanOrEqualTo(Integer value) {
            addCriterion("surver_recoverNum <=", value, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumIn(List<Integer> values) {
            addCriterion("surver_recoverNum in", values, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumNotIn(List<Integer> values) {
            addCriterion("surver_recoverNum not in", values, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumBetween(Integer value1, Integer value2) {
            addCriterion("surver_recoverNum between", value1, value2, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andSurverRecovernumNotBetween(Integer value1, Integer value2) {
            addCriterion("surver_recoverNum not between", value1, value2, "surverRecovernum");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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