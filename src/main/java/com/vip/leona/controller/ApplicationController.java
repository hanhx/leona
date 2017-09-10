package com.vip.leona.controller;


import com.vip.leona.entity.Application;
import com.vip.leona.service.ApplicationService;
import com.vip.leona.util.RestResultUtils;
import com.vip.leona.venum.ResultCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @ApiOperation(value = "API to get a list", httpMethod = "GET")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Object getPandoraEnvApplication() {
        List<Application> list = this.applicationService.getAllApplication();
        return RestResultUtils.successRet(ResultCode.SUCCEED,list);
    }
}
