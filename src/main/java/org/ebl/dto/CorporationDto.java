package org.ebl.dto;

import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationComplaints;

import java.util.List;

/**
 * Created by yeli on 01/08/2017.
 */
public class CorporationDto extends Corporation{


    private List<CorporationComplaints> corporationComplaints;

    public List<CorporationComplaints> getCorporationComplaints() {
        return corporationComplaints;
    }

    public void setCorporationComplaints(List<CorporationComplaints> corporationComplaints) {
        this.corporationComplaints = corporationComplaints;
    }

    public CorporationDto(){}

    public CorporationDto(Corporation corporation){
        this.setId(corporation.getId());
        this.setMark(corporation.getMark());
        this.setName(corporation.getName());
        this.setUpdateTime(corporation.getUpdateTime());
        this.setCreateTime(corporation.getCreateTime());
    }
}
