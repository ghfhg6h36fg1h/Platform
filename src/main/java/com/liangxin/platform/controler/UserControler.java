package com.liangxin.platform.controler;

import com.liangxin.platform.common.entity.advise.generate.pt.User;
import com.liangxin.platform.common.entity.advise.inputParam.user.BaseInput;
import com.liangxin.platform.common.entity.advise.inputParam.user.UserRoleInput;
import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class UserControler {
    @Autowired
    private UserService gUserService;

    @ResponseBody
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public OutResult add(@RequestBody User pUser) {
        return gUserService.addUser(pUser);
    }

    @ResponseBody
    @RequestMapping(value = "/user/getUserList", method = RequestMethod.POST)
    public OutResult getUserList(@RequestBody BaseInput pBaseInput) {
        return gUserService.getUserList(pBaseInput);
    }

    @ResponseBody
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public OutResult update(@RequestBody User pUser) {
        return gUserService.update(pUser);
    }

    @ResponseBody
    @RequestMapping(value = "/user/del", method = RequestMethod.POST)
    public OutResult del(@RequestBody User pUser) {
        return gUserService.del(pUser);
    }

    @ResponseBody
    @RequestMapping(value = "/user/getById/{pId}", method = RequestMethod.GET)
    public OutResult getById(@PathVariable String pId) {
        return gUserService.getById(pId);
    }

    @ResponseBody
    @RequestMapping(value = "/user/addUserRole",method = RequestMethod.POST)
    public OutResult addUserRole(@RequestBody UserRoleInput pUserRoleInput) {
        OutResult mRvalue = gUserService.addUserRole(pUserRoleInput);
        return mRvalue;
    }
}
