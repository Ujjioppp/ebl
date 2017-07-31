package org.ebl.service;

import org.ebl.domain.EblPage;
import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationComplaints;

import java.util.List;

/**
 * Created by yeli on 06/07/2017.
 */
public interface CorporationComplaintsService {
    List<CorporationComplaints> list(EblPage page, Corporation corporation);

    CorporationComplaints add(CorporationComplaints corporationComplaints);
}
