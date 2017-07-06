package org.ebl.service;


import org.ebl.domain.EblPage;
import org.ebl.entity.Corporation;
import org.springframework.data.domain.Page;

/**
 * Created by yeli on 05/07/2017.
 */
public interface CorporationService {
    Page<Corporation> list(EblPage page);
}
