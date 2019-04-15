package com.liangxin.platform.controler.sys;

import com.liangxin.platform.common.entity.advise.outputResult.OutResult;
import com.liangxin.platform.common.entity.sys.mail.MailSet;
import com.liangxin.platform.service.sys.SysMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SysMailControler {

    @Autowired
    private SysMailService gSysMailService;

    @ResponseBody
    @RequestMapping(value = "/outInterface/mail/send", method = RequestMethod.POST)
    public OutResult send(@RequestBody MailSet pMailSet) {
        return gSysMailService.send(pMailSet);
    }

    @ResponseBody
    @RequestMapping(value = "/outInterface/mail/sendBYTemple", method = RequestMethod.POST)
    public OutResult sendBYTemple(@RequestBody MailSet pMailSet) {
        return gSysMailService.sendBYTemple(pMailSet);
    }

}
