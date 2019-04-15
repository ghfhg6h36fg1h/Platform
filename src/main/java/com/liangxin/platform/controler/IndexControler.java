package com.liangxin.platform.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexControler {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public String getJsp(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
                         Model model) {
        model.addAttribute("name", name);
        return "greet";
    }
}
