package com.rory.designpattern.template;

public abstract class AbstractSpeaker {

    public void say(String words) {
        beforeSay();
        System.out.printf("hello" + words);
    }

    protected abstract void beforeSay();

}
