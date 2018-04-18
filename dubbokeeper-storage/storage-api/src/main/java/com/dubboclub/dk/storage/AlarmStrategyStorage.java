package com.dubboclub.dk.storage;

import com.dubboclub.dk.storage.model.AlarmStrategy;

import java.util.List;

public interface AlarmStrategyStorage {

    //修改或者保存报警策略
    public int saveAlarmStrategy(AlarmStrategy strategy);

    //根据应用application查询报警的值
    public List<AlarmStrategy> listAlarmStrategy(String application);

    //根据appName,serviceInterface,
    AlarmStrategy getMethodAlarmStrategy( String appName,
                                                String serviceInterface,
                                                String method);
}