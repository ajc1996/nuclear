package nuclear.model;

import java.util.ArrayList;
import java.util.List;

public class LimitsNuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public LimitsNuExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
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

        public Criteria andLidIsNull() {
            addCriterion("lid is null");
            return (Criteria) this;
        }

        public Criteria andLidIsNotNull() {
            addCriterion("lid is not null");
            return (Criteria) this;
        }

        public Criteria andLidEqualTo(String value) {
            addCriterion("lid =", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotEqualTo(String value) {
            addCriterion("lid <>", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThan(String value) {
            addCriterion("lid >", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThanOrEqualTo(String value) {
            addCriterion("lid >=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThan(String value) {
            addCriterion("lid <", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThanOrEqualTo(String value) {
            addCriterion("lid <=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLike(String value) {
            addCriterion("lid like", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotLike(String value) {
            addCriterion("lid not like", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidIn(List<String> values) {
            addCriterion("lid in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotIn(List<String> values) {
            addCriterion("lid not in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidBetween(String value1, String value2) {
            addCriterion("lid between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotBetween(String value1, String value2) {
            addCriterion("lid not between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLuidIsNull() {
            addCriterion("luid is null");
            return (Criteria) this;
        }

        public Criteria andLuidIsNotNull() {
            addCriterion("luid is not null");
            return (Criteria) this;
        }

        public Criteria andLuidEqualTo(Integer value) {
            addCriterion("luid =", value, "luid");
            return (Criteria) this;
        }

        public Criteria andLuidNotEqualTo(Integer value) {
            addCriterion("luid <>", value, "luid");
            return (Criteria) this;
        }

        public Criteria andLuidGreaterThan(Integer value) {
            addCriterion("luid >", value, "luid");
            return (Criteria) this;
        }

        public Criteria andLuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("luid >=", value, "luid");
            return (Criteria) this;
        }

        public Criteria andLuidLessThan(Integer value) {
            addCriterion("luid <", value, "luid");
            return (Criteria) this;
        }

        public Criteria andLuidLessThanOrEqualTo(Integer value) {
            addCriterion("luid <=", value, "luid");
            return (Criteria) this;
        }

        public Criteria andLuidIn(List<Integer> values) {
            addCriterion("luid in", values, "luid");
            return (Criteria) this;
        }

        public Criteria andLuidNotIn(List<Integer> values) {
            addCriterion("luid not in", values, "luid");
            return (Criteria) this;
        }

        public Criteria andLuidBetween(Integer value1, Integer value2) {
            addCriterion("luid between", value1, value2, "luid");
            return (Criteria) this;
        }

        public Criteria andLuidNotBetween(Integer value1, Integer value2) {
            addCriterion("luid not between", value1, value2, "luid");
            return (Criteria) this;
        }

        public Criteria andLsidIsNull() {
            addCriterion("lsid is null");
            return (Criteria) this;
        }

        public Criteria andLsidIsNotNull() {
            addCriterion("lsid is not null");
            return (Criteria) this;
        }

        public Criteria andLsidEqualTo(Integer value) {
            addCriterion("lsid =", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidNotEqualTo(Integer value) {
            addCriterion("lsid <>", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidGreaterThan(Integer value) {
            addCriterion("lsid >", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lsid >=", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidLessThan(Integer value) {
            addCriterion("lsid <", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidLessThanOrEqualTo(Integer value) {
            addCriterion("lsid <=", value, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidIn(List<Integer> values) {
            addCriterion("lsid in", values, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidNotIn(List<Integer> values) {
            addCriterion("lsid not in", values, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidBetween(Integer value1, Integer value2) {
            addCriterion("lsid between", value1, value2, "lsid");
            return (Criteria) this;
        }

        public Criteria andLsidNotBetween(Integer value1, Integer value2) {
            addCriterion("lsid not between", value1, value2, "lsid");
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