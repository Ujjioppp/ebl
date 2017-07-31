package org.ebl.service.impl;

import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationExample;
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
    public List<Corporation> list(){
        CorporationExample example = new CorporationExample();
        return this.corporationMapper.selectByExample(example);
    }

    @Override
    public Corporation findOne(Long id) {
        return this.corporationMapper.selectByPrimaryKey(id);
    }
}
