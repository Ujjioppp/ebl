package org.ebl.controller;

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

    @GetMapping("/")
    public String index() {
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
}
