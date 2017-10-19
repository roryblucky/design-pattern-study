package com.rory.designpattern.proxy.dynamicProxy;

import com.rory.designpattern.proxy.ICoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CoderInvocationHandler implements InvocationHandler {

    private ICoder coder;

    public CoderInvocationHandler(ICoder coder) {
        this.coder = coder;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if ("writeCode".equals(method.getName())) {
            System.out.println("Dynamic Proxy 需求分析");
            result= method.invoke(coder, args);
            System.out.println("Dynamic Proxy 测试");
        }
        return result;
    }
}
