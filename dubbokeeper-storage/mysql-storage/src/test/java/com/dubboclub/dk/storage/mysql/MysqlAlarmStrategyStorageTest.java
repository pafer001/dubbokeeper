package com.dubboclub.dk.storage.mysql;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MysqlAlarmStrategyStorageTest extends ApplicationStartUp {

    @Autowired
    private MysqlAlarmStrategyStorage mysqlAlarmStrategyStorage;

    @Test
    public void testListAlarmStrategy() {

        mysqlAlarmStrategyStorage.listAlarmStrategy("111");
    }
}
