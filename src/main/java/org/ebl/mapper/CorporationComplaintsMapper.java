package org.ebl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ebl.entity.CorporationComplaints;
import org.ebl.entity.CorporationComplaintsExample;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporationComplaintsMapper {
    int countByExample(CorporationComplaintsExample example);

    int deleteByExample(CorporationComplaintsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CorporationComplaints record);

    int insertSelective(CorporationComplaints record);

    List<CorporationComplaints> selectByExampleWithBLOBs(CorporationComplaintsExample example);

    List<CorporationComplaints> selectByExample(CorporationComplaintsExample example);

    CorporationComplaints selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CorporationComplaints record, @Param("example") CorporationComplaintsExample example);

    int updateByExampleWithBLOBs(@Param("record") CorporationComplaints record, @Param("example") CorporationComplaintsExample example);

    int updateByExample(@Param("record") CorporationComplaints record, @Param("example") CorporationComplaintsExample example);

    int updateByPrimaryKeySelective(CorporationComplaints record);

    int updateByPrimaryKeyWithBLOBs(CorporationComplaints record);

    int updateByPrimaryKey(CorporationComplaints record);
}