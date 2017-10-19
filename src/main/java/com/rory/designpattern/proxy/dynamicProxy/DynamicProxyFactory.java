package com.rory.designpattern.proxy.dynamicProxy;

import com.rory.designpattern.proxy.ICoder;
import com.rory.designpattern.proxy.JavaCoder;

import java.lang.reflect.Proxy;

public class DynamicProxyFactory {

    public static ICoder getInstance() {
        JavaCoder javaCoder = new JavaCoder();
        return (ICoder) Proxy.newProxyInstance(DynamicProxyFactory.class.getClassLoader(), new Class[]{ICoder.class},
                new CoderInvocationHandler(javaCoder));
    }

}
