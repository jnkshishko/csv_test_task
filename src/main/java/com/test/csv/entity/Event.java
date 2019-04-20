package com.test.csv.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "csv")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "ssoid")
    private String ssoid;

    @Column(name = "ts")
    private Long ts;

    @Column(name = "grp")
    private String grp;

    @Column(name = "type_")
    private String type;

    @Column(name = "sub_type")
    private String subtype;

    @Column(name = "url")
    private String url;

    @Column(name = "org_id")
    private String orgId;

    @Column(name = "form_id")
    private String formId;

    @Column(name = "code")
    private String code;

    @Column(name = "ltpa")
    private String ltpa;

    @Column(name = "sudirresponse")
    private String sudirresponse;

    @Column(name = "ymdh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ymdh;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
