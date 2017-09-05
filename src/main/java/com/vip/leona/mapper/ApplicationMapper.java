package com.vip.leona.mapper;

import com.vip.leona.entity.Application;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApplicationMapper {
    List<Application> selectApplication();
}
