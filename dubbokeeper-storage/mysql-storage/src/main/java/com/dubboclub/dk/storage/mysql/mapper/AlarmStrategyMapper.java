package com.dubboclub.dk.storage.mysql.mapper;


import com.dubboclub.dk.storage.model.AlarmStrategy;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlarmStrategyMapper {


    //修改或者保存报警策略
    public int saveAlarmStrategy(AlarmStrategy strategy);

    //根据应用id查询报警的值
    public List<AlarmStrategy> listAlarmStrategy(String application);

    AlarmStrategy getMethodAlarmStrategy(@Param("application")String application,
                                         @Param("serviceInterface")String serviceInterface,
                                         @Param("method")String method);
}
