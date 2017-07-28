package org.ebl.service.impl;

import org.ebl.domain.EblPage;
import org.ebl.repository.CorporationRepository;
import org.ebl.entity.Corporation;
import org.ebl.service.CorporationService;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<Corporation> list(EblPage page){
        Pageable pageable = new PageRequest(page.getPageNum(),page.getPageSize(),new Sort(Sort.Direction.DESC,"updateTime"));
        Page<Corporation> datas = this.corporationRepository.findAll(pageable);
        return datas;
    }

    @Override
    public List<Corporation> list(){
        return this.corporationRepository.findAll();
    }

    @Override
    public Corporation findOne(Long id) {
        return this.corporationRepository.findOne(id);
    }
}
