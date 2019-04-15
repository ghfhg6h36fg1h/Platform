package com.liangxin.platform.mapper.tax;

import com.liangxin.platform.common.entity.tax.inputParam.DeletePicInput;
import com.liangxin.platform.common.entity.tax.inputParam.TaxListInput;
import com.liangxin.platform.common.entity.tax.inputParam.TaxSearchListInput;
import com.liangxin.platform.common.entity.tax.outputParam.TaxExportListOutput;
import com.liangxin.platform.common.entity.tax.outputParam.TaxListOutput;
import com.liangxin.platform.common.entity.tax.pt.Tax;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ITaxMapper {
    //移动端获取列表
    List<TaxListOutput> getTaxList(@Param("pTaxListInput") TaxListInput pTaxListInput);
    //Web端获取列表
    List<TaxListOutput> getSearchTaxList(TaxSearchListInput pTaxSearchListInput);
    //Web端导出列表
    List<TaxExportListOutput> getExportTaxList(TaxSearchListInput pTaxSearchListInput);
    //移动端获取详情，参数全部返回
    Tax getTaxDetail(@Param("sid") int sid);
    //移动端添加的时候判断是否有草稿
    int selectByState(@Param("empno") String empno);
    //移动端插入草稿数据
    int taxInsert(Tax record);
    //移动端获取草稿数据
    Tax getTaxDetailByState(@Param("empno") String empno);
    //提交申请接口,审批接口
    int updateTax(Tax record);
    //删除图片接口
    int deletePic(@Param("pDeletePicInput") DeletePicInput pDeletePicInput);
    //上传图片接口
    int uploadPic(@Param("sid") int sid, @Param("param") String param,@Param("paramtemp") String paramtemp, @Param("value") String value, @Param("temp") String temp, @Param("updatetime")Date updatetime);
}
