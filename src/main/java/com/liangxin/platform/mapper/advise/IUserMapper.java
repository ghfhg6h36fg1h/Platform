package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.Role;
import com.liangxin.platform.common.entity.advise.inputParam.user.BaseInput;
import com.liangxin.platform.common.entity.advise.outputResult.user.BaseOutUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserMapper {

    BaseOutUser getByUserName(@Param("pUserName") String pUserName);

    BaseOutUser getByWorkId(@Param("pWorkId") String pWorkId);

    List<Role> getRoleByUserId(@Param("pUserId") String pUserId);

    List<BaseOutUser> getUserList(@Param("pUser") BaseInput pBaseInput);

    Integer isExistsUser(@Param("pWorkId") String pWorkId,
                         @Param("pMail") String pMail,
                         @Param("pUserName") String pUserName,
                         @Param("pIdCard") String pIdCard,
                         @Param("pPhone") String pPhone,
                         @Param("pId") String pId);

    Integer delRoleRelationToUser(@Param("pUserId") String pUserId);

    Integer addUserRole(@Param("pUserId") String pUserId,
                        @Param("pListRoleIds") List<String> pListRoleIds);

    Integer urlActionRight(@Param("pUserId") String pUserId,
                           @Param("pUrl") String pUrl);
}
