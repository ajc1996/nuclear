package nuclear.model;

import java.io.Serializable;

public class TableResult<GoodsNu> implements Serializable {

    private Integer page;

    private Integer total;

    private GoodsNu rows;

    public TableResult() {
    }

    public TableResult(Integer page, Integer total, GoodsNu rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public GoodsNu getRows() {
        return rows;
    }

    public void setRows(GoodsNu rows) {
        this.rows = rows;
    }
}
