package org.ebl.service.impl;

import org.ebl.domain.Page;
import org.ebl.dao.CorporationRepository;
import org.ebl.entity.Corporation;
import org.ebl.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yeli on 05/07/2017.
 */
@Service("corporationService")
public class CorporationServiceImpl implements CorporationService{
    @Autowired
    private CorporationRepository corporationRepository;

    @Override
    public Page list(Page page){
        Long count = this.corporationRepository.count();
        List<Corporation> datas = this.corporationRepository.findAll(new Sort(Sort.Direction.DESC,"updateTime"));
        page.setDatas(datas);
        page.setTotalRecord(count);
        return page;
    }
}
