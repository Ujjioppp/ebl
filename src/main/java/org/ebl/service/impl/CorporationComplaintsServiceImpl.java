package org.ebl.service.impl;

import org.ebl.domain.EblPage;
import org.ebl.entity.CorporationComplaints;
import org.ebl.repository.CorporationComplaintsRepository;
import org.ebl.service.CorporationComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * Created by yeli on 06/07/2017.
 */
@Service("CorporationComplaintsService")
public class CorporationComplaintsServiceImpl implements CorporationComplaintsService{
    @Autowired
    private CorporationComplaintsRepository corporationComplaintsRepository;

    public Page<CorporationComplaints> list(EblPage page){
        Pageable pageable = new PageRequest(page.getPageNum(),page.getPageSize(), Sort.Direction.DESC,"updateTime");
        Page<CorporationComplaints> datas = this.corporationComplaintsRepository.findAll(pageable);
        return datas;
    }

}
