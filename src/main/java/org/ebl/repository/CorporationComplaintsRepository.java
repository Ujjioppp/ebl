package org.ebl.repository;

import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationComplaints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yeli on 06/07/2017.
 */
public interface CorporationComplaintsRepository extends JpaRepository<CorporationComplaints,Long>{

    Page<CorporationComplaints> findAllByCorporation(Pageable pageable, Corporation corporation);
}
