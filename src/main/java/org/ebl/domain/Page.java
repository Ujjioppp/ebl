package org.ebl.domain;

import java.util.List;

/**
 * Created by yeli on 05/07/2017.
 */
public class Page<T> {
    private Integer pageNum = 1;

    private Long totalRecord = 0l;

    private Long totalPageNum = 1l;

    private Integer pageSize = 20;

    private List<T> datas;

    public Page(){}

    public Page(Long totalRecord , List<T> datas){
        this.totalRecord = totalRecord;
        this.datas = datas;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Long getTotalPageNum() {
        if(this.totalRecord.equals(0)) return 1L;

        Long rest = this.totalRecord % this.pageSize;
        Long fullRecordPageSize = this.totalRecord / this.pageSize;
        if(rest.equals(0)) this.totalPageNum = fullRecordPageSize;
        else this.totalPageNum = fullRecordPageSize + 1;

        return totalPageNum;
    }

    private void setTotalPageNum(Long totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
