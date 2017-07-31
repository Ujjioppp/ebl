package org.ebl.service;


import org.ebl.entity.Corporation;

import java.util.List;

/**
 * Created by yeli on 05/07/2017.
 */
public interface CorporationService {
    List<Corporation> list();

    Corporation findOne(Long id);
}
