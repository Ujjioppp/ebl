package org.ebl.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.ebl.util.DateUtil;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by yeli on 06/07/2017.
 */
@Table(name = "corporation_complaints")
@Entity
public class CorporationComplaints extends BaseEntity {

//    @Column(name = "corporation_id")
    @ManyToOne(targetEntity = Corporation.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "corporation_id")
    @JsonIgnore
    private Corporation corporation;

    @Column(name = "title", nullable = false, length = 255)
    @Length(max = 255,message = "最大长度为255")
    private String title;

    @Column(name = "content", nullable = false)
    @Type(type = "text")
    private String content;

    @Column(name = "create_user", nullable = false)
    private String createUser;

    public Corporation getCorporation() {
        return corporation;
    }

    public void setCorporation(Corporation corporation) {
        this.corporation = corporation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Id
    @GeneratedValue
    public Long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @PrePersist
    void prePersist(){
        this.setCreateTime(DateUtil.now());
        this.setUpdateTime(DateUtil.now());
    }

    @PreUpdate
    void preUpdate(){
        this.setUpdateTime(DateUtil.now());
    }
}
