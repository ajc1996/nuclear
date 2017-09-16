package nuclear.model;

public class TrolleyNu {
    private Integer tid;

    private Integer tuid;

    private Integer tgid;

    private Integer tcount;

    public TrolleyNu(Integer tid, Integer tuid, Integer tgid, Integer tcount) {
        this.tid = tid;
        this.tuid = tuid;
        this.tgid = tgid;
        this.tcount = tcount;
    }

    public TrolleyNu() {
        super();
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getTuid() {
        return tuid;
    }

    public void setTuid(Integer tuid) {
        this.tuid = tuid;
    }

    public Integer getTgid() {
        return tgid;
    }

    public void setTgid(Integer tgid) {
        this.tgid = tgid;
    }

    public Integer getTcount() {
        return tcount;
    }

    public void setTcount(Integer tcount) {
        this.tcount = tcount;
    }
}