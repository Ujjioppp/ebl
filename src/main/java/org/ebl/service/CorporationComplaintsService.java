package org.ebl.service;

import org.ebl.domain.EblPage;
import org.ebl.entity.CorporationComplaints;
import org.springframework.data.domain.Page;

/**
 * Created by yeli on 06/07/2017.
 */
public interface CorporationComplaintsService {
    Page<CorporationComplaints> list(EblPage page);
}
