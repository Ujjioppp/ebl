package org.ebl.service.impl;

import org.ebl.domain.EblPage;
import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationComplaints;
import org.ebl.repository.CorporationComplaintsRepository;
import org.ebl.repository.CorporationRepository;
import org.ebl.service.CorporationComplaintsService;
import org.ebl.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by yeli on 06/07/2017.
 */
@Service("CorporationComplaintsService")
public class CorporationComplaintsServiceImpl implements CorporationComplaintsService {
    @Autowired
    private CorporationComplaintsRepository corporationComplaintsRepository;

    @Autowired
    private CorporationRepository corporationRepository;

    public Page<CorporationComplaints> list(EblPage page, Corporation corporation) {
        Pageable pageable = new PageRequest(page.getPageNum(), page.getPageSize(), Sort.Direction.DESC, "updateTime");
        Page<CorporationComplaints> datas = this.corporationComplaintsRepository.findAllByCorporation(pageable, corporation);
        return datas;
    }

    @Transactional
    public CorporationComplaints add(CorporationComplaints corporationComplaints) {
        Corporation corporation = this.corporationRepository.findByName(corporationComplaints.getCorporation().getName());
        if(corporation == null){
            corporation = corporationComplaints.getCorporation();
            corporation.setMark(BigDecimal.ZERO);
//            corporation = this.corporationRepository.save(corporation);
        }
        corporationComplaints.setCorporation(corporation);
        corporationComplaints.setCreateUser("admin");
        return this.corporationComplaintsRepository.saveAndFlush(corporationComplaints);
    }

}
