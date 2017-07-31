package org.ebl.service.impl;

import org.ebl.domain.EblPage;
import org.ebl.entity.Corporation;
import org.ebl.mapper.CorporationMapper;
import org.ebl.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yeli on 05/07/2017.
 */
@Service("corporationService")
public class CorporationServiceImpl implements CorporationService{
    @Autowired
    private CorporationMapper corporationMapper;

    @Override
    public List<Corporation> list(EblPage page){
//        Pageable pageable = new PageRequest(page.getPageNum(),page.getPageSize(),new Sort(Sort.Direction.DESC,"updateTime"));
//        Page<Corporation> datas = this.corporationRepository.findAll(pageable);
        return null;
    }

    @Override
    public List<Corporation> list(){
        return this.corporationMapper.selectByExample(null);
    }

    @Override
    public Corporation findOne(Long id) {
        return this.corporationMapper.selectByPrimaryKey(id);
    }
}
