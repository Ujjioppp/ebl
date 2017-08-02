package org.ebl.service.impl;

import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationComplaints;
import org.ebl.entity.CorporationComplaintsExample;
import org.ebl.entity.CorporationExample;
import org.ebl.mapper.CorporationComplaintsMapper;
import org.ebl.mapper.CorporationMapper;
import org.ebl.service.CorporationComplaintsService;
import org.ebl.util.DateUtil;
import org.ebl.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by yeli on 06/07/2017.
 */
@Service("CorporationComplaintsService")
public class CorporationComplaintsServiceImpl implements CorporationComplaintsService {
    @Autowired
    private CorporationComplaintsMapper corporationComplaintsMapper;

    @Autowired
    private CorporationMapper corporationMapper;

    public List<CorporationComplaints> list(CorporationComplaints corporationComplaints) {
        CorporationComplaintsExample corporationComplaintsExample = new CorporationComplaintsExample();
        corporationComplaintsExample.setOrderByClause("update_time desc");
        CorporationComplaintsExample.Criteria criteria = corporationComplaintsExample.createCriteria();
        if(corporationComplaints.getCorporationId() != null)
            criteria.andCorporationIdEqualTo(corporationComplaints.getCorporationId());

        return this.corporationComplaintsMapper.selectByExampleWithBLOBs(corporationComplaintsExample);
    }

    @Transactional
    public CorporationComplaints add(Corporation corporation,CorporationComplaints corporationComplaints,HttpServletRequest request) {
        CorporationExample example = new CorporationExample();
        example.createCriteria().andNameEqualTo(corporation.getName());
        List<Corporation> tempCorporations = this.corporationMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(tempCorporations)){
            corporation.setMark(BigDecimal.ZERO);
            corporation.setCreateTime(DateUtil.now());
            corporation.setUpdateTime(DateUtil.now());
            this.corporationMapper.insertSelective(corporation);
        }else{
            corporation = tempCorporations.get(0);
            corporation.setUpdateTime(DateUtil.now());
            this.corporationMapper.updateByPrimaryKeySelective(corporation);
        }
        corporationComplaints.setCreateUser(IpUtil.getLocalIp(request));
        corporationComplaints.setCorporationId(corporation.getId());
        corporationComplaints.setCreateTime(DateUtil.now());
        corporationComplaints.setUpdateTime(DateUtil.now());
        this.corporationComplaintsMapper.insertSelective(corporationComplaints);
        return corporationComplaints;
    }

}
