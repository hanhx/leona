package com.vip.leona.service.impl;

import com.vip.leona.entity.Application;
import com.vip.leona.mapper.ApplicationMapper;
import com.vip.leona.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Override
    public List<Application> getAllApplication() {
        return this.applicationMapper.selectApplication();
    }
}
