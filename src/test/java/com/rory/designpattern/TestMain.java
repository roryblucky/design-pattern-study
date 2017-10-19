package com.rory.designpattern;

import com.rory.designpattern.adaptor.*;
import com.rory.designpattern.factory.abstracFactory.CarFactoryA;
import com.rory.designpattern.factory.abstracFactory.CarFactoryB;
import com.rory.designpattern.factory.normalFactory.BMWFactory;
import com.rory.designpattern.factory.simpleFactory.AudiCar;
import com.rory.designpattern.factory.simpleFactory.BMWCar;
import com.rory.designpattern.factory.simpleFactory.CarSimpleFactory;
import com.rory.designpattern.observer.custom.CustomHouse;
import com.rory.designpattern.observer.custom.CustomPerson;
import com.rory.designpattern.observer.usejdk.House;
import com.rory.designpattern.observer.usejdk.Person;
import com.rory.designpattern.proxy.ICoder;
import com.rory.designpattern.proxy.dynamicProxy.DynamicProxyFactory;
import com.rory.designpattern.proxy.staticProxy.StaticProxyFactory;
import com.rory.designpattern.singleton.Singleton;
import com.rory.designpattern.strategy.NormalStrategy;
import com.rory.designpattern.strategy.SimpleStrategy;
import com.rory.designpattern.strategy.StrategyProvider;
import com.rory.designpattern.template.ChineseSpeaker;
import org.junit.Assert;
import org.junit.Test;

public class TestMain {


    @Test
    public void testSingleton() {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        Assert.assertEquals(singleton, singleton2);
    }

    @Test
    public void testFactory() {
        //1. simpleFactory
        CarSimpleFactory simpleFactory = new CarSimpleFactory();
        BMWCar car = (BMWCar) simpleFactory.getCar("bmw");
        Assert.assertEquals(car.getCarNum(), "333333");

        //2. Normal Factory
        BMWFactory bmwFactory = new BMWFactory();
        BMWCar car1 = (BMWCar) bmwFactory.produceCar("888888");
        Assert.assertEquals(car1.getCarNum(), "888888");

        //3. Abstract Factory
        CarFactoryA carFactoryA = new CarFactoryA();
        AudiCar audiCar = (AudiCar) carFactoryA.produceAudi("1111");
        BMWCar bmwCar = (BMWCar) carFactoryA.produceBMW("2222");
        Assert.assertTrue(audiCar.getCarNum().contains("!") && bmwCar.getCarNum().contains("!"));

        CarFactoryB carFactoryB = new CarFactoryB();
        AudiCar audiCar1 = (AudiCar) carFactoryB.produceAudi("1111");
        BMWCar bmwCar1 = (BMWCar) carFactoryB.produceBMW("2222");
        Assert.assertEquals(audiCar1.getCarNum(), "1111");
        Assert.assertEquals(bmwCar1.getCarNum(), "2222");
    }

    @Test
    public void testStrategy() {
        NormalStrategy normalStrategy = new NormalStrategy();
        StrategyProvider provider = new StrategyProvider(normalStrategy);
        provider.execute("1111");

        SimpleStrategy simpleStrategy = new SimpleStrategy();
        StrategyProvider provider1 = new StrategyProvider(simpleStrategy);
        provider1.execute("2222");
    }

    @Test
    public void testTemplate() {
        ChineseSpeaker chineseSpeaker = new ChineseSpeaker();
        chineseSpeaker.say("你好");
    }

    @Test
    public void testProxy() {
        //1. static proxy
        ICoder coder = StaticProxyFactory.getInstance();
        coder.writeCode("Code");

        //2.DynamicProxy
        ICoder proxCoder = DynamicProxyFactory.getInstance();
        proxCoder.writeCode("code");
    }

    @Test
    public void testAdaptor() {
        //220V加上适配器使用110V插孔充电,将110V电压转换成220V
        PowerSocket220V powerSocket220V = new PowerSocket220VImpl();
        PowerSocket110VAdaptor adaptor = new PowerSocket110VAdaptor(powerSocket220V);
        adaptor.rechargeBy110V();
    }

    @Test
    public void testObserve() {
        //jdk方式
        House house = new House();
        Person p1 = new Person("1");
        Person p2= new Person("2");
        Person p3 = new Person("3");
        house.addObserver(p1);
        house.addObserver(p2);
        house.addObserver(p3);
        house.setPrice(1111);

        //custom observe
        CustomHouse house1 = new CustomHouse();
        CustomPerson person1 = new CustomPerson("1");
        CustomPerson person2 = new CustomPerson("2");
        CustomPerson person3 = new CustomPerson("3");
        house1.addObserver(person1);
        house1.addObserver(person2);
        house1.addObserver(person3);
        house1.setPrice(2222);
    }
}
