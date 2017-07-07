package org.ebl.repository;

import org.ebl.entity.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yeli on 05/07/2017.
 */
public interface CorporationRepository extends JpaRepository<Corporation,Long>{
}
