package nuclear.model;

public class ControlNu {
    private Integer cid;

    private String cname;

    private String curl;

    private String cpic;

    public ControlNu(Integer cid, String cname, String curl, String cpic) {
        this.cid = cid;
        this.cname = cname;
        this.curl = curl;
        this.cpic = cpic;
    }

    public ControlNu() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCurl() {
        return curl;
    }

    public void setCurl(String curl) {
        this.curl = curl == null ? null : curl.trim();
    }

    public String getCpic() {
        return cpic;
    }

    public void setCpic(String cpic) {
        this.cpic = cpic == null ? null : cpic.trim();
    }
}