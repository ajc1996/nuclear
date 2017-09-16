package nuclear.model;

import java.util.Date;

public class UserNu {
    private Integer uid;

    private String uname;

    private String upassword;

    private String upic;

    private String usex;

    private Date ubirthday;

    private Integer ulimits;

    private String uphone;

    public UserNu(Integer uid, String uname, String upassword, String upic, String usex, Date ubirthday, Integer ulimits, String uphone) {
        this.uid = uid;
        this.uname = uname;
        this.upassword = upassword;
        this.upic = upic;
        this.usex = usex;
        this.ubirthday = ubirthday;
        this.ulimits = ulimits;
        this.uphone = uphone;
    }

    public UserNu() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public String getUpic() {
        return upic;
    }

    public void setUpic(String upic) {
        this.upic = upic == null ? null : upic.trim();
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex == null ? null : usex.trim();
    }

    public Date getUbirthday() {
        return ubirthday;
    }

    public void setUbirthday(Date ubirthday) {
        this.ubirthday = ubirthday;
    }

    public Integer getUlimits() {
        return ulimits;
    }

    public void setUlimits(Integer ulimits) {
        this.ulimits = ulimits;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone == null ? null : uphone.trim();
    }
}