package com.dubboclub.dk.storage.model;

import java.io.Serializable;

public class InterfaceServiceMethod implements Serializable {

    private String application;

    private String serviceInterface;

    private String method;

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

    @Override
    public String toString() {
        return "ApplicationServiceMethod{" +
                "application='" + application + '\'' +
                ", serviceInterface='" + serviceInterface + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
