package org.ebl.controller;

import com.github.pagehelper.PageHelper;
import org.ebl.domain.PageInfo;
import org.ebl.entity.CorporationComplaints;
import org.ebl.service.CorporationComplaintsService;
import org.ebl.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yeli on 03/07/2017.
 */
@Controller
@RequestMapping("/")
public class PageController {
    @Autowired
    private CorporationService corporationService;

    @Autowired
    private CorporationComplaintsService corporationComplaintsService;

    @GetMapping("/")
    public String index(String k,Model model) {
        model.addAttribute("name",k);
        return "index";
    }

    @GetMapping("/complaints/{id}")
    public String corporationComplaints(@PathVariable("id") Long id, Model model) {
        model.addAttribute("target", this.corporationService.findOne(id));
        return "complaints";
    }

    @GetMapping("/complain")
    public String complain(){
        return "complain";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
