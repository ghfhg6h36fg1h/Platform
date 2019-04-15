package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.Role;
import com.liangxin.platform.common.entity.advise.inputParam.role.RoleInput;
import com.liangxin.platform.common.entity.advise.inputParam.role.RoleMenuActionInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RoleControler {
    @Autowired
    private RoleService gRoleService;
    @ResponseBody
    @RequestMapping(value = "/role/getAll",method = RequestMethod.POST)
    public OutResult getAll(@RequestBody RoleInput pListInput) {
        OutResult mRvalue = gRoleService.getAll(pListInput);
        return mRvalue;
    }
    @ResponseBody
    @RequestMapping(value = "/role/add",method = RequestMethod.POST)
    public OutResult add(@RequestBody Role pRole) {
        OutResult mRvalue = gRoleService.add(pRole);
        return mRvalue;
    }
    @ResponseBody
    @RequestMapping(value = "/role/update",method = RequestMethod.POST)
    public OutResult update(@RequestBody Role pRole) {
        OutResult mRvalue = gRoleService.update(pRole);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/role/del",method = RequestMethod.POST)
    public OutResult del(@RequestBody Role pRole) {
        OutResult mRvalue = gRoleService.del(pRole);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/role/{pId}",method = RequestMethod.GET)
    public OutResult getAll(@PathVariable String pId) {
        OutResult mRvalue = gRoleService.getById(pId);
        return mRvalue;
    }

    @ResponseBody
    @RequestMapping(value = "/role/addMenuAction",method = RequestMethod.POST)
    public OutResult addMenuAction(@RequestBody RoleMenuActionInput pRoleMenuActionInput) {
        OutResult mRvalue = gRoleService.addMenuAction(pRoleMenuActionInput);
        return mRvalue;
    }
}
