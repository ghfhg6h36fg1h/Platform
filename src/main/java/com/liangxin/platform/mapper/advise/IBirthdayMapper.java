package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.Birthday;
import com.liangxin.platform.common.entity.advise.inputParam.birthday.BirthdayInput;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IBirthdayMapper {
    List<Birthday> getBirthdayAll(@Param("pBirthdayInput") BirthdayInput pBirthdayInput);
    int ignoreById(Birthday record);
}
