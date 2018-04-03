package com.rory.designpattern.bridge;

public abstract class AbstractMessage {
    private String msg;
    private String target;

    public AbstractMessage(String msg, String target) {
        this.msg = msg;
        this.target = target;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
