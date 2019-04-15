package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.Menu;
import com.liangxin.platform.common.entity.advise.inputParam.menu.InputMenuForOAList;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.MenuService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.LinkedList;

@Controller
public class MenuControler {

    @Autowired
    private MenuService gMenuService;

    @ResponseBody
    @RequestMapping(value = "/menu/getAll",method = RequestMethod.POST)
    public OutResult getAll(@RequestBody InputMenuForOAList pInputMenuForOAList) {
        return gMenuService.getAll(pInputMenuForOAList);
    }


    @ResponseBody
    @RequestMapping(value = "/menu/add",method = RequestMethod.POST)
    public OutResult add(@RequestBody Menu pMenu) {
        return gMenuService.add(pMenu);
    }

    @ResponseBody
    @RequestMapping(value = "/menu/update",method = RequestMethod.POST)
    public OutResult update(@RequestBody Menu pMenu) {
        return gMenuService.update(pMenu);
    }

    @ResponseBody
    @RequestMapping(value = "/menu/{pId}",method = RequestMethod.GET)
    public OutResult update(@PathVariable String pId) {
        return gMenuService.getById(pId);
    }

    @ResponseBody
    @RequestMapping(value = "/menu/delMenuNode/{pId}",method = RequestMethod.GET)
    public OutResult delMenuNode(@PathVariable String pId) {
        return gMenuService.delMenuNode(pId);
    }
    @ResponseBody
    @RequestMapping(value = "/menu/getAllByUser",method = RequestMethod.GET)
    public OutResult getAllByUser(HttpServletRequest pHttpServletRequest) {
        return gMenuService.getAllByUser(pHttpServletRequest);
    }
    @ResponseBody
    @RequestMapping(value = "/menu/getAllConsistRole/{pRoleId}",method = RequestMethod.GET)
    public OutResult getAllConsistRole(@PathVariable String pRoleId) {
        return gMenuService.getAllConsistRole(pRoleId);
    }

}
