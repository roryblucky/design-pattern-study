package com.rory.designpattern.proxy.staticProxy;

import com.rory.designpattern.proxy.ICoder;

public class ProxyJavaCoder implements ICoder {
    private ICoder coder;

    public ProxyJavaCoder(ICoder coder) {
        this.coder = coder;
    }

    @Override
    public void writeCode(String code) {
        System.out.println("Static Proxy 需求分析");
        coder.writeCode(code);
        System.out.println("Static Proxy 测试");
    }
}
