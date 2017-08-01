package org.ebl.controller;

import com.github.pagehelper.PageHelper;
import org.ebl.domain.EblPage;
import org.ebl.domain.PageInfo;
import org.ebl.domain.Result;
import org.ebl.entity.Corporation;
import org.ebl.entity.CorporationComplaints;
import org.ebl.service.CorporationComplaintsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by yeli on 06/07/2017.
 */
@RestController
@RequestMapping("complaints")
public class CorporationComplaintsController {
    @Autowired
    private CorporationComplaintsService corporationComplaintsService;

    @RequestMapping("/list")
    public Result list(PageInfo page, CorporationComplaints corporationComplaints) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        List<CorporationComplaints> datas = this.corporationComplaintsService.list(corporationComplaints);
        return Result.buildSuccessResult(new PageInfo<CorporationComplaints>(datas));
    }



    @PutMapping("/add")
    public Result add(CorporationComplaints corporationComplaints, Corporation corporation, HttpServletRequest request) {
        corporationComplaints = this.corporationComplaintsService.add(corporation,corporationComplaints,request);
        return Result.buildSuccessResult(corporationComplaints.getCorporationId());

    }
}
