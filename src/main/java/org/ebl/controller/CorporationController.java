package org.ebl.controller;

import org.ebl.domain.EblPage;
import org.ebl.domain.Result;
import org.ebl.entity.Corporation;
import org.ebl.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public Result list(EblPage page){
        Page<Corporation> datas = this.corporationService.list(page);
        return Result.buildSuccessResult(datas);
    }
}
