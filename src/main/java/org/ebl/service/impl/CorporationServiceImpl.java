package org.ebl.service.impl;

import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationExample;
import org.ebl.mapper.CorporationMapper;
import org.ebl.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by yeli on 05/07/2017.
 */
@Service("corporationService")
public class CorporationServiceImpl implements CorporationService {
    @Autowired
    private CorporationMapper corporationMapper;

    @Override
    public List<Corporation> list(Corporation corporation) {
        CorporationExample example = new CorporationExample();
        if (!StringUtils.isEmpty(corporation.getName())) {
            example.createCriteria().andNameLike("%" + corporation.getName() + "%");
        }
        return this.corporationMapper.selectByExample(example);
    }

    @Override
    public List<Corporation> list() {
        return this.list(new Corporation());
    }

    @Override
    public Corporation findOne(Long id) {
        return this.corporationMapper.selectByPrimaryKey(id);
    }
}
