package org.ebl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yeli on 03/07/2017.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("test","test");
        return "index";
    }
}
