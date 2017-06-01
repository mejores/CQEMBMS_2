package com.edu.entity;

import java.util.ArrayList;
import java.util.List;

public class InfoPlateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoPlateExample() {
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

        public Criteria andPlateIdIsNull() {
            addCriterion("plate_id is null");
            return (Criteria) this;
        }

        public Criteria andPlateIdIsNotNull() {
            addCriterion("plate_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlateIdEqualTo(Integer value) {
            addCriterion("plate_id =", value, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateIdNotEqualTo(Integer value) {
            addCriterion("plate_id <>", value, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateIdGreaterThan(Integer value) {
            addCriterion("plate_id >", value, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("plate_id >=", value, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateIdLessThan(Integer value) {
            addCriterion("plate_id <", value, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateIdLessThanOrEqualTo(Integer value) {
            addCriterion("plate_id <=", value, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateIdIn(List<Integer> values) {
            addCriterion("plate_id in", values, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateIdNotIn(List<Integer> values) {
            addCriterion("plate_id not in", values, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateIdBetween(Integer value1, Integer value2) {
            addCriterion("plate_id between", value1, value2, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateIdNotBetween(Integer value1, Integer value2) {
            addCriterion("plate_id not between", value1, value2, "plateId");
            return (Criteria) this;
        }

        public Criteria andPlateNoIsNull() {
            addCriterion("plate_no is null");
            return (Criteria) this;
        }

        public Criteria andPlateNoIsNotNull() {
            addCriterion("plate_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlateNoEqualTo(String value) {
            addCriterion("plate_no =", value, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoNotEqualTo(String value) {
            addCriterion("plate_no <>", value, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoGreaterThan(String value) {
            addCriterion("plate_no >", value, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoGreaterThanOrEqualTo(String value) {
            addCriterion("plate_no >=", value, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoLessThan(String value) {
            addCriterion("plate_no <", value, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoLessThanOrEqualTo(String value) {
            addCriterion("plate_no <=", value, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoLike(String value) {
            addCriterion("plate_no like", value, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoNotLike(String value) {
            addCriterion("plate_no not like", value, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoIn(List<String> values) {
            addCriterion("plate_no in", values, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoNotIn(List<String> values) {
            addCriterion("plate_no not in", values, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoBetween(String value1, String value2) {
            addCriterion("plate_no between", value1, value2, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNoNotBetween(String value1, String value2) {
            addCriterion("plate_no not between", value1, value2, "plateNo");
            return (Criteria) this;
        }

        public Criteria andPlateNameIsNull() {
            addCriterion("plate_name is null");
            return (Criteria) this;
        }

        public Criteria andPlateNameIsNotNull() {
            addCriterion("plate_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlateNameEqualTo(String value) {
            addCriterion("plate_name =", value, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameNotEqualTo(String value) {
            addCriterion("plate_name <>", value, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameGreaterThan(String value) {
            addCriterion("plate_name >", value, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameGreaterThanOrEqualTo(String value) {
            addCriterion("plate_name >=", value, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameLessThan(String value) {
            addCriterion("plate_name <", value, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameLessThanOrEqualTo(String value) {
            addCriterion("plate_name <=", value, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameLike(String value) {
            addCriterion("plate_name like", value, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameNotLike(String value) {
            addCriterion("plate_name not like", value, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameIn(List<String> values) {
            addCriterion("plate_name in", values, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameNotIn(List<String> values) {
            addCriterion("plate_name not in", values, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameBetween(String value1, String value2) {
            addCriterion("plate_name between", value1, value2, "plateName");
            return (Criteria) this;
        }

        public Criteria andPlateNameNotBetween(String value1, String value2) {
            addCriterion("plate_name not between", value1, value2, "plateName");
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