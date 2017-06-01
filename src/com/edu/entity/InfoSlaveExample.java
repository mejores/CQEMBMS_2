package com.edu.entity;

import java.util.ArrayList;
import java.util.List;

public class InfoSlaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoSlaveExample() {
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

        public Criteria andSlaveIdIsNull() {
            addCriterion("slave_id is null");
            return (Criteria) this;
        }

        public Criteria andSlaveIdIsNotNull() {
            addCriterion("slave_id is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveIdEqualTo(Integer value) {
            addCriterion("slave_id =", value, "slaveId");
            return (Criteria) this;
        }

        public Criteria andSlaveIdNotEqualTo(Integer value) {
            addCriterion("slave_id <>", value, "slaveId");
            return (Criteria) this;
        }

        public Criteria andSlaveIdGreaterThan(Integer value) {
            addCriterion("slave_id >", value, "slaveId");
            return (Criteria) this;
        }

        public Criteria andSlaveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("slave_id >=", value, "slaveId");
            return (Criteria) this;
        }

        public Criteria andSlaveIdLessThan(Integer value) {
            addCriterion("slave_id <", value, "slaveId");
            return (Criteria) this;
        }

        public Criteria andSlaveIdLessThanOrEqualTo(Integer value) {
            addCriterion("slave_id <=", value, "slaveId");
            return (Criteria) this;
        }

        public Criteria andSlaveIdIn(List<Integer> values) {
            addCriterion("slave_id in", values, "slaveId");
            return (Criteria) this;
        }

        public Criteria andSlaveIdNotIn(List<Integer> values) {
            addCriterion("slave_id not in", values, "slaveId");
            return (Criteria) this;
        }

        public Criteria andSlaveIdBetween(Integer value1, Integer value2) {
            addCriterion("slave_id between", value1, value2, "slaveId");
            return (Criteria) this;
        }

        public Criteria andSlaveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("slave_id not between", value1, value2, "slaveId");
            return (Criteria) this;
        }

        public Criteria andConNoIsNull() {
            addCriterion("con_no is null");
            return (Criteria) this;
        }

        public Criteria andConNoIsNotNull() {
            addCriterion("con_no is not null");
            return (Criteria) this;
        }

        public Criteria andConNoEqualTo(String value) {
            addCriterion("con_no =", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoNotEqualTo(String value) {
            addCriterion("con_no <>", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoGreaterThan(String value) {
            addCriterion("con_no >", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoGreaterThanOrEqualTo(String value) {
            addCriterion("con_no >=", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoLessThan(String value) {
            addCriterion("con_no <", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoLessThanOrEqualTo(String value) {
            addCriterion("con_no <=", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoLike(String value) {
            addCriterion("con_no like", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoNotLike(String value) {
            addCriterion("con_no not like", value, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoIn(List<String> values) {
            addCriterion("con_no in", values, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoNotIn(List<String> values) {
            addCriterion("con_no not in", values, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoBetween(String value1, String value2) {
            addCriterion("con_no between", value1, value2, "conNo");
            return (Criteria) this;
        }

        public Criteria andConNoNotBetween(String value1, String value2) {
            addCriterion("con_no not between", value1, value2, "conNo");
            return (Criteria) this;
        }

        public Criteria andPhyNameIsNull() {
            addCriterion("phy_name is null");
            return (Criteria) this;
        }

        public Criteria andPhyNameIsNotNull() {
            addCriterion("phy_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhyNameEqualTo(String value) {
            addCriterion("phy_name =", value, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameNotEqualTo(String value) {
            addCriterion("phy_name <>", value, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameGreaterThan(String value) {
            addCriterion("phy_name >", value, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameGreaterThanOrEqualTo(String value) {
            addCriterion("phy_name >=", value, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameLessThan(String value) {
            addCriterion("phy_name <", value, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameLessThanOrEqualTo(String value) {
            addCriterion("phy_name <=", value, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameLike(String value) {
            addCriterion("phy_name like", value, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameNotLike(String value) {
            addCriterion("phy_name not like", value, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameIn(List<String> values) {
            addCriterion("phy_name in", values, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameNotIn(List<String> values) {
            addCriterion("phy_name not in", values, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameBetween(String value1, String value2) {
            addCriterion("phy_name between", value1, value2, "phyName");
            return (Criteria) this;
        }

        public Criteria andPhyNameNotBetween(String value1, String value2) {
            addCriterion("phy_name not between", value1, value2, "phyName");
            return (Criteria) this;
        }

        public Criteria andLogNameIsNull() {
            addCriterion("log_name is null");
            return (Criteria) this;
        }

        public Criteria andLogNameIsNotNull() {
            addCriterion("log_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogNameEqualTo(String value) {
            addCriterion("log_name =", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotEqualTo(String value) {
            addCriterion("log_name <>", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThan(String value) {
            addCriterion("log_name >", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_name >=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThan(String value) {
            addCriterion("log_name <", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLessThanOrEqualTo(String value) {
            addCriterion("log_name <=", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameLike(String value) {
            addCriterion("log_name like", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotLike(String value) {
            addCriterion("log_name not like", value, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameIn(List<String> values) {
            addCriterion("log_name in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotIn(List<String> values) {
            addCriterion("log_name not in", values, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameBetween(String value1, String value2) {
            addCriterion("log_name between", value1, value2, "logName");
            return (Criteria) this;
        }

        public Criteria andLogNameNotBetween(String value1, String value2) {
            addCriterion("log_name not between", value1, value2, "logName");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
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