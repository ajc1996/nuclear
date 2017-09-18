package nuclear.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsNuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public GoodsNuExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGpriceIsNull() {
            addCriterion("gprice is null");
            return (Criteria) this;
        }

        public Criteria andGpriceIsNotNull() {
            addCriterion("gprice is not null");
            return (Criteria) this;
        }

        public Criteria andGpriceEqualTo(Double value) {
            addCriterion("gprice =", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotEqualTo(Double value) {
            addCriterion("gprice <>", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceGreaterThan(Double value) {
            addCriterion("gprice >", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("gprice >=", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceLessThan(Double value) {
            addCriterion("gprice <", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceLessThanOrEqualTo(Double value) {
            addCriterion("gprice <=", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceIn(List<Double> values) {
            addCriterion("gprice in", values, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotIn(List<Double> values) {
            addCriterion("gprice not in", values, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceBetween(Double value1, Double value2) {
            addCriterion("gprice between", value1, value2, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotBetween(Double value1, Double value2) {
            addCriterion("gprice not between", value1, value2, "gprice");
            return (Criteria) this;
        }

        public Criteria andGintroIsNull() {
            addCriterion("gintro is null");
            return (Criteria) this;
        }

        public Criteria andGintroIsNotNull() {
            addCriterion("gintro is not null");
            return (Criteria) this;
        }

        public Criteria andGintroEqualTo(String value) {
            addCriterion("gintro =", value, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroNotEqualTo(String value) {
            addCriterion("gintro <>", value, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroGreaterThan(String value) {
            addCriterion("gintro >", value, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroGreaterThanOrEqualTo(String value) {
            addCriterion("gintro >=", value, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroLessThan(String value) {
            addCriterion("gintro <", value, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroLessThanOrEqualTo(String value) {
            addCriterion("gintro <=", value, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroLike(String value) {
            addCriterion("gintro like", value, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroNotLike(String value) {
            addCriterion("gintro not like", value, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroIn(List<String> values) {
            addCriterion("gintro in", values, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroNotIn(List<String> values) {
            addCriterion("gintro not in", values, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroBetween(String value1, String value2) {
            addCriterion("gintro between", value1, value2, "gintro");
            return (Criteria) this;
        }

        public Criteria andGintroNotBetween(String value1, String value2) {
            addCriterion("gintro not between", value1, value2, "gintro");
            return (Criteria) this;
        }

        public Criteria andGpicIsNull() {
            addCriterion("gpic is null");
            return (Criteria) this;
        }

        public Criteria andGpicIsNotNull() {
            addCriterion("gpic is not null");
            return (Criteria) this;
        }

        public Criteria andGpicEqualTo(String value) {
            addCriterion("gpic =", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicNotEqualTo(String value) {
            addCriterion("gpic <>", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicGreaterThan(String value) {
            addCriterion("gpic >", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicGreaterThanOrEqualTo(String value) {
            addCriterion("gpic >=", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicLessThan(String value) {
            addCriterion("gpic <", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicLessThanOrEqualTo(String value) {
            addCriterion("gpic <=", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicLike(String value) {
            addCriterion("gpic like", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicNotLike(String value) {
            addCriterion("gpic not like", value, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicIn(List<String> values) {
            addCriterion("gpic in", values, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicNotIn(List<String> values) {
            addCriterion("gpic not in", values, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicBetween(String value1, String value2) {
            addCriterion("gpic between", value1, value2, "gpic");
            return (Criteria) this;
        }

        public Criteria andGpicNotBetween(String value1, String value2) {
            addCriterion("gpic not between", value1, value2, "gpic");
            return (Criteria) this;
        }

        public Criteria andGrepertoryIsNull() {
            addCriterion("grepertory is null");
            return (Criteria) this;
        }

        public Criteria andGrepertoryIsNotNull() {
            addCriterion("grepertory is not null");
            return (Criteria) this;
        }

        public Criteria andGrepertoryEqualTo(Integer value) {
            addCriterion("grepertory =", value, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGrepertoryNotEqualTo(Integer value) {
            addCriterion("grepertory <>", value, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGrepertoryGreaterThan(Integer value) {
            addCriterion("grepertory >", value, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGrepertoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("grepertory >=", value, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGrepertoryLessThan(Integer value) {
            addCriterion("grepertory <", value, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGrepertoryLessThanOrEqualTo(Integer value) {
            addCriterion("grepertory <=", value, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGrepertoryIn(List<Integer> values) {
            addCriterion("grepertory in", values, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGrepertoryNotIn(List<Integer> values) {
            addCriterion("grepertory not in", values, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGrepertoryBetween(Integer value1, Integer value2) {
            addCriterion("grepertory between", value1, value2, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGrepertoryNotBetween(Integer value1, Integer value2) {
            addCriterion("grepertory not between", value1, value2, "grepertory");
            return (Criteria) this;
        }

        public Criteria andGbirthdayIsNull() {
            addCriterion("gbirthday is null");
            return (Criteria) this;
        }

        public Criteria andGbirthdayIsNotNull() {
            addCriterion("gbirthday is not null");
            return (Criteria) this;
        }

        public Criteria andGbirthdayEqualTo(Date value) {
            addCriterion("gbirthday =", value, "gbirthday");
            return (Criteria) this;
        }

        public Criteria andGbirthdayNotEqualTo(Date value) {
            addCriterion("gbirthday <>", value, "gbirthday");
            return (Criteria) this;
        }

        public Criteria andGbirthdayGreaterThan(Date value) {
            addCriterion("gbirthday >", value, "gbirthday");
            return (Criteria) this;
        }

        public Criteria andGbirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("gbirthday >=", value, "gbirthday");
            return (Criteria) this;
        }

        public Criteria andGbirthdayLessThan(Date value) {
            addCriterion("gbirthday <", value, "gbirthday");
            return (Criteria) this;
        }

        public Criteria andGbirthdayLessThanOrEqualTo(Date value) {
            addCriterion("gbirthday <=", value, "gbirthday");
            return (Criteria) this;
        }

        public Criteria andGbirthdayIn(List<Date> values) {
            addCriterion("gbirthday in", values, "gbirthday");
            return (Criteria) this;
        }

        public Criteria andGbirthdayNotIn(List<Date> values) {
            addCriterion("gbirthday not in", values, "gbirthday");
            return (Criteria) this;
        }

        public Criteria andGbirthdayBetween(Date value1, Date value2) {
            addCriterion("gbirthday between", value1, value2, "gbirthday");
            return (Criteria) this;
        }

        public Criteria andGbirthdayNotBetween(Date value1, Date value2) {
            addCriterion("gbirthday not between", value1, value2, "gbirthday");
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