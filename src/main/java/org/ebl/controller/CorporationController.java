package org.ebl.controller;

import org.ebl.domain.Page;
import org.ebl.domain.Result;
import org.ebl.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yeli on 05/07/2017.
 */
@RestController
@RequestMapping("/corporation")
public class CorporationController {
    @Autowired
    private CorporationService corporationService;

    @GetMapping("/list")
    public Result list(Page page){
        page = this.corporationService.list(page);
        return Result.buildSuccessResult(page);
    }
}
