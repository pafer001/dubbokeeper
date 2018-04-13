package com.dubboclub.dk.storage.model;

import java.io.Serializable;

public class AlarmStrategy implements Serializable{

    //项目名字
    private String application;
    //接口名字
    private String serviceInterface;
    //方法名字
    private String method;
    //qps
    private double tps;
    //响应时间
    private long elapsed;
    //发送错误的次数
    private long failureCount;
    //1有效，0无效
    private int effective;

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getServiceInterface() {
        return serviceInterface;
    }

    public void setServiceInterface(String serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getTps() {
        return tps;
    }

    public void setTps(double tps) {
        this.tps = tps;
    }

    public long getElapsed() {
        return elapsed;
    }

    public void setElapsed(long elapsed) {
        this.elapsed = elapsed;
    }

    public long getFailureCount() {
        return failureCount;
    }

    public void setFailureCount(long failureCount) {
        this.failureCount = failureCount;
    }

    public int getEffective() {
        return effective;
    }

    public void setEffective(int effective) {
        this.effective = effective;
    }

    @Override
    public String toString() {
        return "AlarmStrategy{" +
                "application='" + application + '\'' +
                ", serviceInterface='" + serviceInterface + '\'' +
                ", method='" + method + '\'' +
                ", tps=" + tps +
                ", elapsed=" + elapsed +
                ", failureCount=" + failureCount +
                '}';
    }

    public static class AlarmStrategyBuilder{

        public static AlarmStrategy fromInterfaceServiceMethod(InterfaceServiceMethod method) {
            AlarmStrategy alarmStrategy = new AlarmStrategy();
            alarmStrategy.setApplication(method.getApplication());
            alarmStrategy.setServiceInterface(method.getServiceInterface());
            alarmStrategy.setMethod(method.getMethod());
            return alarmStrategy;
        }
    }
}




