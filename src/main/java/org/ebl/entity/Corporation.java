package org.ebl.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.ebl.util.DateUtil;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * Created by yeli on 05/07/2017.
 */
@Table(name = "corporation")
@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Corporation extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mark", nullable = false, length = 5, scale = 2)
    private BigDecimal mark;

    @OneToMany(mappedBy = "corporation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("updateTime desc")
//    @JsonIgnore
    private Set<CorporationComplaints> complaints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getMark() {
        return mark;
    }

    public void setMark(BigDecimal mark) {
        this.mark = mark;
    }

    public Set<CorporationComplaints> getComplaints() {
        return complaints;
    }

    public void setComplaints(Set<CorporationComplaints> complaints) {
        this.complaints = complaints;
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
