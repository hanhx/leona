package com.vip.leona.Service;


import com.vip.leona.entity.Application;
import com.vip.leona.service.ApplicationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationServiceTest {

    private final static Logger logger = LoggerFactory.getLogger(ApplicationServiceTest.class);
    @Autowired
    private ApplicationService applicationService;

    @Test
    public void getAllApplicationTest(){
        List<Application> list = this.applicationService.getAllApplication();
        logger.info(" "+list.size());
        list.forEach( application -> {
            logger.info(" "+application);
        });
        assertTrue(!list.isEmpty());
    }
}
