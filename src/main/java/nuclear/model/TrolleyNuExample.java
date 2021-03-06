package nuclear.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TrolleyNuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public TrolleyNuExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTuidIsNull() {
            addCriterion("tuid is null");
            return (Criteria) this;
        }

        public Criteria andTuidIsNotNull() {
            addCriterion("tuid is not null");
            return (Criteria) this;
        }

        public Criteria andTuidEqualTo(Integer value) {
            addCriterion("tuid =", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidNotEqualTo(Integer value) {
            addCriterion("tuid <>", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidGreaterThan(Integer value) {
            addCriterion("tuid >", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tuid >=", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidLessThan(Integer value) {
            addCriterion("tuid <", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidLessThanOrEqualTo(Integer value) {
            addCriterion("tuid <=", value, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidIn(List<Integer> values) {
            addCriterion("tuid in", values, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidNotIn(List<Integer> values) {
            addCriterion("tuid not in", values, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidBetween(Integer value1, Integer value2) {
            addCriterion("tuid between", value1, value2, "tuid");
            return (Criteria) this;
        }

        public Criteria andTuidNotBetween(Integer value1, Integer value2) {
            addCriterion("tuid not between", value1, value2, "tuid");
            return (Criteria) this;
        }

        public Criteria andTgidIsNull() {
            addCriterion("tgid is null");
            return (Criteria) this;
        }

        public Criteria andTgidIsNotNull() {
            addCriterion("tgid is not null");
            return (Criteria) this;
        }

        public Criteria andTgidEqualTo(Integer value) {
            addCriterion("tgid =", value, "tgid");
            return (Criteria) this;
        }

        public Criteria andTgidNotEqualTo(Integer value) {
            addCriterion("tgid <>", value, "tgid");
            return (Criteria) this;
        }

        public Criteria andTgidGreaterThan(Integer value) {
            addCriterion("tgid >", value, "tgid");
            return (Criteria) this;
        }

        public Criteria andTgidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tgid >=", value, "tgid");
            return (Criteria) this;
        }

        public Criteria andTgidLessThan(Integer value) {
            addCriterion("tgid <", value, "tgid");
            return (Criteria) this;
        }

        public Criteria andTgidLessThanOrEqualTo(Integer value) {
            addCriterion("tgid <=", value, "tgid");
            return (Criteria) this;
        }

        public Criteria andTgidIn(List<Integer> values) {
            addCriterion("tgid in", values, "tgid");
            return (Criteria) this;
        }

        public Criteria andTgidNotIn(List<Integer> values) {
            addCriterion("tgid not in", values, "tgid");
            return (Criteria) this;
        }

        public Criteria andTgidBetween(Integer value1, Integer value2) {
            addCriterion("tgid between", value1, value2, "tgid");
            return (Criteria) this;
        }

        public Criteria andTgidNotBetween(Integer value1, Integer value2) {
            addCriterion("tgid not between", value1, value2, "tgid");
            return (Criteria) this;
        }

        public Criteria andTcountIsNull() {
            addCriterion("tcount is null");
            return (Criteria) this;
        }

        public Criteria andTcountIsNotNull() {
            addCriterion("tcount is not null");
            return (Criteria) this;
        }

        public Criteria andTcountEqualTo(Integer value) {
            addCriterion("tcount =", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountNotEqualTo(Integer value) {
            addCriterion("tcount <>", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountGreaterThan(Integer value) {
            addCriterion("tcount >", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("tcount >=", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountLessThan(Integer value) {
            addCriterion("tcount <", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountLessThanOrEqualTo(Integer value) {
            addCriterion("tcount <=", value, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountIn(List<Integer> values) {
            addCriterion("tcount in", values, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountNotIn(List<Integer> values) {
            addCriterion("tcount not in", values, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountBetween(Integer value1, Integer value2) {
            addCriterion("tcount between", value1, value2, "tcount");
            return (Criteria) this;
        }

        public Criteria andTcountNotBetween(Integer value1, Integer value2) {
            addCriterion("tcount not between", value1, value2, "tcount");
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