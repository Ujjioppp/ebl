package org.ebl.controller;

import com.alibaba.fastjson.JSONObject;
import org.ebl.domain.EblPage;
import org.ebl.domain.Result;
import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationComplaints;
import org.ebl.service.CorporationComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by yeli on 06/07/2017.
 */
@RestController
@RequestMapping("complaints")
public class CorporationComplaintsController {
    @Autowired
    private CorporationComplaintsService corporationComplaintsService;

    @RequestMapping("/list")
    public Result list(EblPage page, Corporation corporation){
        Page<CorporationComplaints> datas = this.corporationComplaintsService.list(page,corporation);
        return Result.buildSuccessResult(datas);
    }

    @PutMapping("/add")
    public Result add(@Valid CorporationComplaints corporationComplaints){
        corporationComplaints = this.corporationComplaintsService.add(corporationComplaints);
        return Result.buildSuccessResult(corporationComplaints.getCorporation().getId());

    }
}
