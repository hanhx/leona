package com.vip.leona.controller;


import com.vip.leona.entity.Application;
import com.vip.leona.exception.BusinessException;
import com.vip.leona.service.ApplicationService;
import com.vip.leona.util.RestResultUtils;
import com.vip.leona.venum.ResultCode;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "API to get a test", httpMethod = "GET")
    @RequestMapping(value = "/test/{name}", method = RequestMethod.GET)
    public Object getPandoraTest(@PathVariable("name") String name){
        if (StringUtils.equals(name,"hysonhan")){
            throw new BusinessException(ResultCode.TEST_PARAM.getCode(),ResultCode.TEST_PARAM.name(),null,"000","999");
        }
        return RestResultUtils.successRet(ResultCode.SUCCEED,"内容为空");
    }
}
