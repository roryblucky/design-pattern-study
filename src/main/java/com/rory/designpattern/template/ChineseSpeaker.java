package com.rory.designpattern.template;

public class ChineseSpeaker extends AbstractSpeaker{

    @Override
    protected void beforeSay()  {
        System.out.println("这是中国话");
    }

}
