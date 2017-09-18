package nuclear.model;

import org.springframework.stereotype.Service;

@Service
public class LimitsNu {
    private String lid;

    private Integer luid;

    private Integer lsid;

    public LimitsNu(String lid, Integer luid, Integer lsid) {
        this.lid = lid;
        this.luid = luid;
        this.lsid = lsid;
    }

    public LimitsNu() {
        super();
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid == null ? null : lid.trim();
    }

    public Integer getLuid() {
        return luid;
    }

    public void setLuid(Integer luid) {
        this.luid = luid;
    }

    public Integer getLsid() {
        return lsid;
    }

    public void setLsid(Integer lsid) {
        this.lsid = lsid;
    }
}