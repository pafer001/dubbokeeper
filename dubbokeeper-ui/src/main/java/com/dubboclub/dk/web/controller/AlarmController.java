package com.dubboclub.dk.web.controller;

import com.dubboclub.dk.storage.AlarmStrategyStorage;
import com.dubboclub.dk.storage.StatisticsStorage;
import com.dubboclub.dk.storage.model.AlarmStrategy;
import com.dubboclub.dk.storage.model.ApplicationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/alarm")
public class AlarmController {

    @Autowired
    private AlarmStrategyStorage alarmStrategyStorage;
    @Autowired
    @Qualifier("statisticsStorage")
    private StatisticsStorage statisticsStorage;

    @RequestMapping("/{appName}/strategy.htm")
    public @ResponseBody
    List<AlarmStrategy> getAlarmStrategy(@PathVariable("appName") String appName) {
        return alarmStrategyStorage.listAlarmStrategy(appName);
    }

    @RequestMapping("/index.htm")
    public @ResponseBody
    Collection<ApplicationInfo> monitorIndex() {
        return statisticsStorage.queryApplications();
    }


//    @RequestMapping("/{appName}/strategy.htm")
//    public @ResponseBody
//    List<AlarmStrategy> getAlarmStrategy(@PathVariable("appName") String appName) {
//        return alarmStrategyStorage.listAlarmStrategy(appName);
//    }
}
