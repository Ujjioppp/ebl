package org.ebl.controller;

import com.github.pagehelper.PageHelper;
import org.ebl.domain.PageInfo;
import org.ebl.domain.Result;
import org.ebl.entity.Corporation;
import org.ebl.service.CorporationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yeli on 05/07/2017.
 */
@RestController
@RequestMapping("/corporation")
public class CorporationController {
    @Autowired
    private CorporationService corporationService;

    @GetMapping("/list")
    public Result list(PageInfo page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Corporation> datas = this.corporationService.list();
        return Result.buildSuccessResult(new PageInfo<Corporation>(datas));
    }

    @GetMapping("/allList")
    public Result allList() {
        List<Corporation> datas = this.corporationService.list();
        return Result.buildSuccessResult(datas);
    }
}
