package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.Anniversary;
import com.liangxin.platform.common.entity.advise.inputParam.anniversary.AnniversaryInput;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IAnniversaryMapper {
    List<Anniversary> getAnniversaryAll(@Param("pAnniversaryInput") AnniversaryInput pAnniversaryInput);
    int ignoreById(Anniversary record);
}