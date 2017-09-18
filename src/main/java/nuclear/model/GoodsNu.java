package nuclear.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class GoodsNu {
    private Integer gid;

    private String gname;

    private Double gprice;

    private String gintro;

    private String gpic;

    private Integer grepertory;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gbirthday;

    public GoodsNu(Integer gid, String gname, Double gprice, String gintro, String gpic, Integer grepertory, Date gbirthday) {
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
        this.gintro = gintro;
        this.gpic = gpic;
        this.grepertory = grepertory;
        this.gbirthday = gbirthday;
    }

    public GoodsNu() {
        super();
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public String getGintro() {
        return gintro;
    }

    public void setGintro(String gintro) {
        this.gintro = gintro == null ? null : gintro.trim();
    }

    public String getGpic() {
        return gpic;
    }

    public void setGpic(String gpic) {
        this.gpic = gpic == null ? null : gpic.trim();
    }

    public Integer getGrepertory() {
        return grepertory;
    }

    public void setGrepertory(Integer grepertory) {
        this.grepertory = grepertory;
    }

    public Date getGbirthday() {
        return gbirthday;
    }

    public void setGbirthday(Date gbirthday) {
        this.gbirthday = gbirthday;
    }
}