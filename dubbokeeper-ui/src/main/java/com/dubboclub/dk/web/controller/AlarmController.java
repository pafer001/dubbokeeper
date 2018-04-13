package com.dubboclub.dk.web.controller;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.dubboclub.dk.admin.model.Application;
import com.dubboclub.dk.admin.service.ApplicationService;
import com.dubboclub.dk.storage.AlarmStrategyStorage;
import com.dubboclub.dk.storage.StatisticsStorage;
import com.dubboclub.dk.storage.model.AlarmStrategy;
import com.dubboclub.dk.storage.model.ApplicationInfo;
import com.dubboclub.dk.storage.model.InterfaceServiceMethod;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/alarm")
public class AlarmController {

    @Autowired
    private AlarmStrategyStorage alarmStrategyStorage;
    @Autowired
    @Qualifier("statisticsStorage")
    private StatisticsStorage statisticsStorage;
    @Autowired
    private ApplicationService applicationService;

    @RequestMapping("/app/list.htm")
    public @ResponseBody
    List<Application> getApplications() {
        Collection<ApplicationInfo> applicationInfos = statisticsStorage.queryMonitorApplications();
        List<Application> applications = applicationService.getApplications();
        if (CollectionUtils.isEmpty(applications) || CollectionUtils.isEmpty(applicationInfos)) {
            return Lists.newArrayList();
        }
        Set<String> set = Sets.newHashSet();
        for (ApplicationInfo applicationInfo : applicationInfos) {
            set.add(applicationInfo.getApplicationName());
        }

        List<Application> objects = Lists.newArrayList();

        for (Application application : applications) {
            if (set.contains(application.getApplication().toLowerCase())) {
                objects.add(application);
            }
        }

        return objects;
    }

    @RequestMapping("/{appName}/{serviceInterface}/{method}/strategy.htm")
    public @ResponseBody
    AlarmStrategy getMethodAlarmStrategy(@PathVariable("appName") String appName,
                                         @PathVariable("serviceInterface") String serviceInterface,
                                         @PathVariable("method") String method) {
        AlarmStrategy methodAlarmStrategy = alarmStrategyStorage.getMethodAlarmStrategy(appName, serviceInterface, method);
        if (methodAlarmStrategy == null) {
            methodAlarmStrategy = new AlarmStrategy();
        }
        methodAlarmStrategy.setMethod(method);
        methodAlarmStrategy.setServiceInterface(serviceInterface);
        methodAlarmStrategy.setApplication(appName);
        return methodAlarmStrategy;
    }

    @RequestMapping("/{appName}/strategy.htm")
    public @ResponseBody
    List<AlarmStrategy> getAlarmStrategy(@PathVariable("appName") String appName) {
        Collection<InterfaceServiceMethod> methods = statisticsStorage.getInterfaceServiceMethod(appName);
        if (CollectionUtils.isEmpty(methods)) {
            return Lists.newArrayList();
        }

        List<AlarmStrategy> alarmStrategies = alarmStrategyStorage.listAlarmStrategy(appName);

        Map<String, AlarmStrategy> map = Maps.newHashMap();

        for (AlarmStrategy alarmStrategy : alarmStrategies) {
            String key = Joiner.on("-").join(Lists.newArrayList(alarmStrategy.getApplication(),
                    alarmStrategy.getServiceInterface(), alarmStrategy.getMethod()));
            map.put(key, alarmStrategy);
        }

        for (InterfaceServiceMethod interfaceServiceMethod : methods) {
            String key = Joiner.on("-").join(Lists.newArrayList(interfaceServiceMethod.getApplication(),
                    interfaceServiceMethod.getServiceInterface(), interfaceServiceMethod.getMethod()));

            if (map.containsKey(key)) {
                continue;
            }

            AlarmStrategy alarmStrategy = AlarmStrategy.AlarmStrategyBuilder.fromInterfaceServiceMethod(interfaceServiceMethod);
            alarmStrategies.add(alarmStrategy);
        }

        return alarmStrategies;
    }

    @RequestMapping("/index.htm")
    public @ResponseBody
    Map monitorIndex() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("service", "service");
        return map;
    }

}
