package org.ebl.service.impl;

import org.ebl.domain.EblPage;
import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationComplaints;
import org.ebl.mapper.CorporationComplaintsMapper;
import org.ebl.mapper.CorporationMapper;
import org.ebl.service.CorporationComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public List<CorporationComplaints> list(EblPage page, Corporation corporation) {
//        Pageable pageable = new PageRequest(page.getPageNum(), page.getPageSize(), Sort.Direction.DESC, "updateTime");
//        Page<CorporationComplaints1> datas = this.corporationComplaintsRepository.findAllByCorporation(pageable, corporation);
        return null;
    }

    @Transactional
    public CorporationComplaints add(CorporationComplaints corporationComplaints) {
//        Corporation corporation = this.corporationRepository.findByName(corporationComplaints.getCorporation().getName());
//        if(corporation == null){
//            corporation = corporationComplaints.getCorporation();
//            corporation.setMark(BigDecimal.ZERO);
////            corporation = this.corporationRepository.save(corporation);
//        }
//        corporationComplaints.setCorporation(corporation);
//        corporationComplaints.setCreateUser("admin");
        return null;
    }

}
