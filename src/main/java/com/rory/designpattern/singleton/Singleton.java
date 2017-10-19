package com.rory.designpattern.singleton;


/**
 * 线程安全的无锁的单利模式
 */
public class Singleton {
    private Singleton() {}

    public static Singleton getInstance() {
        return Nested.INSTANCE;
    }

    private static class Nested {
        private static Singleton INSTANCE = new Singleton();
    }
}
