package com.edu.entity;

import java.util.ArrayList;
import java.util.List;

public class InfoSlideExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InfoSlideExample() {
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

        public Criteria andSlideIdIsNull() {
            addCriterion("slide_id is null");
            return (Criteria) this;
        }

        public Criteria andSlideIdIsNotNull() {
            addCriterion("slide_id is not null");
            return (Criteria) this;
        }

        public Criteria andSlideIdEqualTo(Integer value) {
            addCriterion("slide_id =", value, "slideId");
            return (Criteria) this;
        }

        public Criteria andSlideIdNotEqualTo(Integer value) {
            addCriterion("slide_id <>", value, "slideId");
            return (Criteria) this;
        }

        public Criteria andSlideIdGreaterThan(Integer value) {
            addCriterion("slide_id >", value, "slideId");
            return (Criteria) this;
        }

        public Criteria andSlideIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("slide_id >=", value, "slideId");
            return (Criteria) this;
        }

        public Criteria andSlideIdLessThan(Integer value) {
            addCriterion("slide_id <", value, "slideId");
            return (Criteria) this;
        }

        public Criteria andSlideIdLessThanOrEqualTo(Integer value) {
            addCriterion("slide_id <=", value, "slideId");
            return (Criteria) this;
        }

        public Criteria andSlideIdIn(List<Integer> values) {
            addCriterion("slide_id in", values, "slideId");
            return (Criteria) this;
        }

        public Criteria andSlideIdNotIn(List<Integer> values) {
            addCriterion("slide_id not in", values, "slideId");
            return (Criteria) this;
        }

        public Criteria andSlideIdBetween(Integer value1, Integer value2) {
            addCriterion("slide_id between", value1, value2, "slideId");
            return (Criteria) this;
        }

        public Criteria andSlideIdNotBetween(Integer value1, Integer value2) {
            addCriterion("slide_id not between", value1, value2, "slideId");
            return (Criteria) this;
        }

        public Criteria andImgPathIsNull() {
            addCriterion("img_path is null");
            return (Criteria) this;
        }

        public Criteria andImgPathIsNotNull() {
            addCriterion("img_path is not null");
            return (Criteria) this;
        }

        public Criteria andImgPathEqualTo(String value) {
            addCriterion("img_path =", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotEqualTo(String value) {
            addCriterion("img_path <>", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathGreaterThan(String value) {
            addCriterion("img_path >", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("img_path >=", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLessThan(String value) {
            addCriterion("img_path <", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLessThanOrEqualTo(String value) {
            addCriterion("img_path <=", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathLike(String value) {
            addCriterion("img_path like", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotLike(String value) {
            addCriterion("img_path not like", value, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathIn(List<String> values) {
            addCriterion("img_path in", values, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotIn(List<String> values) {
            addCriterion("img_path not in", values, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathBetween(String value1, String value2) {
            addCriterion("img_path between", value1, value2, "imgPath");
            return (Criteria) this;
        }

        public Criteria andImgPathNotBetween(String value1, String value2) {
            addCriterion("img_path not between", value1, value2, "imgPath");
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

        public Criteria andImgConIsNull() {
            addCriterion("img_con is null");
            return (Criteria) this;
        }

        public Criteria andImgConIsNotNull() {
            addCriterion("img_con is not null");
            return (Criteria) this;
        }

        public Criteria andImgConEqualTo(String value) {
            addCriterion("img_con =", value, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConNotEqualTo(String value) {
            addCriterion("img_con <>", value, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConGreaterThan(String value) {
            addCriterion("img_con >", value, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConGreaterThanOrEqualTo(String value) {
            addCriterion("img_con >=", value, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConLessThan(String value) {
            addCriterion("img_con <", value, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConLessThanOrEqualTo(String value) {
            addCriterion("img_con <=", value, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConLike(String value) {
            addCriterion("img_con like", value, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConNotLike(String value) {
            addCriterion("img_con not like", value, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConIn(List<String> values) {
            addCriterion("img_con in", values, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConNotIn(List<String> values) {
            addCriterion("img_con not in", values, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConBetween(String value1, String value2) {
            addCriterion("img_con between", value1, value2, "imgCon");
            return (Criteria) this;
        }

        public Criteria andImgConNotBetween(String value1, String value2) {
            addCriterion("img_con not between", value1, value2, "imgCon");
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