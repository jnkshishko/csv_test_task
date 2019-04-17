package com.test.csv.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CSV", schema = "public")
public class Event {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "SSOID")
    private String ssoid;

    @Column(name = "TS")
    private Long ts;

    @Column(name = "GRP")
    private String grp;

    @Column(name = "TYPE_")
    private String type;

    @Column(name = "SUB_TYPE")
    private String subtype;

    @Column(name = "URL")
    private String url;

    @Column(name = "ORG_ID")
    private String orgId;

    @Column(name = "FORM_ID")
    private String formId;

    @Column(name = "CODE")
    private String code;

    @Column(name = "LTPA")
    private String ltpa;

    @Column(name = "SUDIRRESPONSE")
    private String sudirresponse;

    @Column(name = "YMDH")
    @Temporal(TemporalType.DATE)
    private Date ymdh;

    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSudirresponse() {
        return sudirresponse;
    }

    public void setSudirresponse(String sudirresponse) {
        this.sudirresponse = sudirresponse;
    }

    public Date getYmdh() {
        return ymdh;
    }

    public void setYmdh(Date ymdh) {
        this.ymdh = ymdh;
    }
}
