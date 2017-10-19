package com.rory.designpattern.proxy.staticProxy;

import com.rory.designpattern.proxy.ICoder;
import com.rory.designpattern.proxy.JavaCoder;

public class StaticProxyFactory {

    private StaticProxyFactory(){}

    public static ICoder getInstance() {
        return new ProxyJavaCoder(new JavaCoder());
    }
}
