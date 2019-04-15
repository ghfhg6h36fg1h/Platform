package com.liangxin.platform.mapper.care;

import com.liangxin.platform.common.entity.LXYKT.AddMoneyInfo;
import com.liangxin.platform.common.entity.care.inputParas.ExpireAndMemberInput;
import com.liangxin.platform.common.entity.care.outputResult.Employee;
import com.liangxin.platform.common.entity.care.outputResult.ExpireAndMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface IEmployeeMapper {
    List<Employee> getBirthdayAll(@Param("pDate") String pDate);

    List<Employee> getAnniversaryAll(@Param("pDate") String pDate);

    List<ExpireAndMember> getReadyToMemberList(@Param("pExpireAndMemberInput") ExpireAndMemberInput pExpireAndMemberInput);

    List<ExpireAndMember> getContractExpireList(@Param("pExpireAndMemberInput") ExpireAndMemberInput pExpireAndMemberInput);

    Map<String, Object> getUpGradeNameAndUserId(@Param("pUserId") String pUserId);
}