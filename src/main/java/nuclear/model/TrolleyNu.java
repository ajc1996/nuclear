package nuclear.model;

import org.springframework.stereotype.Service;

@Service
public class TrolleyNu extends GoodsNu{
    private Integer tid;

    private Integer tuid;

    @Override
    public String toString() {
        return "TrolleyNu{" +
                "tid=" + tid +
                ", tuid=" + tuid +
                ", tgid=" + tgid +
                ", tcount=" + tcount +
                ", gid=" + getGid() +
                ", gname=" + getGname() +
                ", gprice=" + getGprice() +
                ", gintro=" + getGintro() +
                ", gpic=" + getGpic() +
                ", grepertory=" + getGrepertory() +
                ", gbirthday=" + getGbirthday() +
                '}';
    }

    private Integer tgid;

    private Integer tcount;

    public void setGoodsNu(GoodsNu goodsNu){
        this.setGid(goodsNu.getGid());
        this.setGname(goodsNu.getGname());
        this.setGprice(goodsNu.getGprice());
        this.setGintro(goodsNu.getGintro());
        this.setGpic(goodsNu.getGpic());
        this.setGrepertory(goodsNu.getGrepertory());
        this.setGbirthday(goodsNu.getGbirthday());
    }

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