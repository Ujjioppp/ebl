package org.ebl.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationExample;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporationMapper {
    int countByExample(CorporationExample example);

    int deleteByExample(CorporationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Corporation record);

    int insertSelective(Corporation record);

    List<Corporation> selectByExample(CorporationExample example);

    Corporation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Corporation record, @Param("example") CorporationExample example);

    int updateByExample(@Param("record") Corporation record, @Param("example") CorporationExample example);

    int updateByPrimaryKeySelective(Corporation record);

    int updateByPrimaryKey(Corporation record);
}