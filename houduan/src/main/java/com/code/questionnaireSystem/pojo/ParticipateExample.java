package com.code.questionnaireSystem.pojo;

import java.util.ArrayList;
import java.util.List;

public class ParticipateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ParticipateExample() {
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

        public Criteria andParticipateIdIsNull() {
            addCriterion("\"participate _id\" is null");
            return (Criteria) this;
        }

        public Criteria andParticipateIdIsNotNull() {
            addCriterion("\"participate _id\" is not null");
            return (Criteria) this;
        }

        public Criteria andParticipateIdEqualTo(String value) {
            addCriterion("\"participate _id\" =", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdNotEqualTo(String value) {
            addCriterion("\"participate _id\" <>", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdGreaterThan(String value) {
            addCriterion("\"participate _id\" >", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdGreaterThanOrEqualTo(String value) {
            addCriterion("\"participate _id\" >=", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdLessThan(String value) {
            addCriterion("\"participate _id\" <", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdLessThanOrEqualTo(String value) {
            addCriterion("\"participate _id\" <=", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdLike(String value) {
            addCriterion("\"participate _id\" like", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdNotLike(String value) {
            addCriterion("\"participate _id\" not like", value, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdIn(List<String> values) {
            addCriterion("\"participate _id\" in", values, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdNotIn(List<String> values) {
            addCriterion("\"participate _id\" not in", values, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdBetween(String value1, String value2) {
            addCriterion("\"participate _id\" between", value1, value2, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIdNotBetween(String value1, String value2) {
            addCriterion("\"participate _id\" not between", value1, value2, "participateId");
            return (Criteria) this;
        }

        public Criteria andParticipateIpIsNull() {
            addCriterion("\"participate _ip\" is null");
            return (Criteria) this;
        }

        public Criteria andParticipateIpIsNotNull() {
            addCriterion("\"participate _ip\" is not null");
            return (Criteria) this;
        }

        public Criteria andParticipateIpEqualTo(String value) {
            addCriterion("\"participate _ip\" =", value, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpNotEqualTo(String value) {
            addCriterion("\"participate _ip\" <>", value, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpGreaterThan(String value) {
            addCriterion("\"participate _ip\" >", value, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpGreaterThanOrEqualTo(String value) {
            addCriterion("\"participate _ip\" >=", value, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpLessThan(String value) {
            addCriterion("\"participate _ip\" <", value, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpLessThanOrEqualTo(String value) {
            addCriterion("\"participate _ip\" <=", value, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpLike(String value) {
            addCriterion("\"participate _ip\" like", value, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpNotLike(String value) {
            addCriterion("\"participate _ip\" not like", value, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpIn(List<String> values) {
            addCriterion("\"participate _ip\" in", values, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpNotIn(List<String> values) {
            addCriterion("\"participate _ip\" not in", values, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpBetween(String value1, String value2) {
            addCriterion("\"participate _ip\" between", value1, value2, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateIpNotBetween(String value1, String value2) {
            addCriterion("\"participate _ip\" not between", value1, value2, "participateIp");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceIsNull() {
            addCriterion("\"participate _device\" is null");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceIsNotNull() {
            addCriterion("\"participate _device\" is not null");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceEqualTo(String value) {
            addCriterion("\"participate _device\" =", value, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceNotEqualTo(String value) {
            addCriterion("\"participate _device\" <>", value, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceGreaterThan(String value) {
            addCriterion("\"participate _device\" >", value, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceGreaterThanOrEqualTo(String value) {
            addCriterion("\"participate _device\" >=", value, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceLessThan(String value) {
            addCriterion("\"participate _device\" <", value, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceLessThanOrEqualTo(String value) {
            addCriterion("\"participate _device\" <=", value, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceLike(String value) {
            addCriterion("\"participate _device\" like", value, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceNotLike(String value) {
            addCriterion("\"participate _device\" not like", value, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceIn(List<String> values) {
            addCriterion("\"participate _device\" in", values, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceNotIn(List<String> values) {
            addCriterion("\"participate _device\" not in", values, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceBetween(String value1, String value2) {
            addCriterion("\"participate _device\" between", value1, value2, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateDeviceNotBetween(String value1, String value2) {
            addCriterion("\"participate _device\" not between", value1, value2, "participateDevice");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaIsNull() {
            addCriterion("\"participate _area\" is null");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaIsNotNull() {
            addCriterion("\"participate _area\" is not null");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaEqualTo(String value) {
            addCriterion("\"participate _area\" =", value, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaNotEqualTo(String value) {
            addCriterion("\"participate _area\" <>", value, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaGreaterThan(String value) {
            addCriterion("\"participate _area\" >", value, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaGreaterThanOrEqualTo(String value) {
            addCriterion("\"participate _area\" >=", value, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaLessThan(String value) {
            addCriterion("\"participate _area\" <", value, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaLessThanOrEqualTo(String value) {
            addCriterion("\"participate _area\" <=", value, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaLike(String value) {
            addCriterion("\"participate _area\" like", value, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaNotLike(String value) {
            addCriterion("\"participate _area\" not like", value, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaIn(List<String> values) {
            addCriterion("\"participate _area\" in", values, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaNotIn(List<String> values) {
            addCriterion("\"participate _area\" not in", values, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaBetween(String value1, String value2) {
            addCriterion("\"participate _area\" between", value1, value2, "participateArea");
            return (Criteria) this;
        }

        public Criteria andParticipateAreaNotBetween(String value1, String value2) {
            addCriterion("\"participate _area\" not between", value1, value2, "participateArea");
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