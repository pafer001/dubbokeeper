package com.dubboclub.dk.storage.mysql;

import com.dubboclub.dk.storage.AlarmStrategyStorage;
import com.dubboclub.dk.storage.model.AlarmStrategy;
import com.dubboclub.dk.storage.mysql.mapper.AlarmStrategyMapper;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

public class MysqlAlarmStrategyStorage implements AlarmStrategyStorage , InitializingBean {

    private AlarmStrategyMapper alarmStrategyMapper;

    @Override
    public int saveAlarmStrategy(AlarmStrategy strategy) {
        return alarmStrategyMapper.saveAlarmStrategy(strategy);
    }

    @Override
    public List<AlarmStrategy> listAlarmStrategy(String application) {
        return alarmStrategyMapper.listAlarmStrategy(application);
    }

    public AlarmStrategyMapper getAlarmStrategyMapper() {
        return alarmStrategyMapper;
    }

    public void setAlarmStrategyMapper(AlarmStrategyMapper alarmStrategyMapper) {
        this.alarmStrategyMapper = alarmStrategyMapper;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
