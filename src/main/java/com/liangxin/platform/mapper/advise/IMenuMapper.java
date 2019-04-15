package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.Menu;
import com.liangxin.platform.common.entity.advise.inputParam.menu.InputMenuForOAList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface IMenuMapper {

    /**
     * 获取MenuList
     *
     * @param pInputMenuForOAList
     * @return
     */
    List<Menu> getAll(@Param("pInputMenuForOAList") InputMenuForOAList pInputMenuForOAList);

    int updateMenuNode(@Param("pId") String pId,
                       @Param("pValue") Integer pValue,
                       @Param("pIsDel") boolean pIsDel);

    Integer isExistsTopDisable(@Param("pId") String pId);

    List<Menu> getAllByUser(@Param("pUserId") String pUserId);

    List<Menu> getAllConsistRole(@Param("pRoleId") String pRoleId);

    Integer delRoleRelationToMenu(@Param("pId") String pId);
    //判断是否存在此路由
    Integer isExistsByAction(@Param("pAction") String pAction);
}
