package com.liangxin.platform.mapper.advise;

import com.liangxin.platform.common.entity.advise.generate.pt.StrategyAccord;
import com.liangxin.platform.common.entity.advise.inputParam.strategyAccord.StrategyAccordMainInput;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IStrategyAccordMapper {

    List<StrategyAccord> selectByCondition(StrategyAccordMainInput pStrategyAccordMainInput);

    List<StrategyAccord> selectByConditionXieTong(StrategyAccordMainInput pStrategyAccordMainInput);
}
