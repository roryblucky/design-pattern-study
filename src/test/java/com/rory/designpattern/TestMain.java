package com.rory.designpattern;

import com.rory.designpattern.adaptor.PowerSocket110VAdaptor;
import com.rory.designpattern.adaptor.PowerSocket220V;
import com.rory.designpattern.adaptor.PowerSocket220VImpl;
import com.rory.designpattern.builder.ComputerBuilder;
import com.rory.designpattern.builder.Director;
import com.rory.designpattern.builder.IComputerBuilder;
import com.rory.designpattern.decorator.BeefDecorator;
import com.rory.designpattern.decorator.Foods;
import com.rory.designpattern.decorator.Noodle;
import com.rory.designpattern.decorator.SaltDecorator;
import com.rory.designpattern.facade.Computer;
import com.rory.designpattern.factory.abstracFactory.CarFactoryA;
import com.rory.designpattern.factory.abstracFactory.CarFactoryB;
import com.rory.designpattern.factory.normalFactory.BMWFactory;
import com.rory.designpattern.factory.simpleFactory.AudiCar;
import com.rory.designpattern.factory.simpleFactory.BMWCar;
import com.rory.designpattern.factory.simpleFactory.CarSimpleFactory;
import com.rory.designpattern.observer.custom.ISubject;
import com.rory.designpattern.observer.custom.Observer1;
import com.rory.designpattern.observer.custom.Observer2;
import com.rory.designpattern.observer.custom.SubjectImpl;
import com.rory.designpattern.observer.event.AddEvent;
import com.rory.designpattern.observer.event.AddEventListener;
import com.rory.designpattern.observer.event.DelEventListener;
import com.rory.designpattern.observer.event.EventPublisher;
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
//        House house = new House();
//        Person p1 = new Person("1");
//        Person p2= new Person("2");
//        Person p3 = new Person("3");
//        house.addObserver(p1);
//        house.addObserver(p2);
//        house.addObserver(p3);
//        house.setPrice(1111);

        //custom observe
        ISubject subject = new SubjectImpl();
        subject.addObserver(new Observer1());
        subject.addObserver(new Observer2());
        subject.notifyAllObservers();
    }

    @Test
    public void testFacade() {
        Computer computer = new Computer();//Facade
        computer.start();
    }

    @Test
    public void testDecorator() {
        Foods foods = new Noodle();
        BeefDecorator beefDecorator = new BeefDecorator("beef", foods);
        SaltDecorator saltDecorator = new SaltDecorator("salt", beefDecorator);
        saltDecorator.cook();
    }

    @Test
    public void testBuilder() {
        //I need a new computer. I ask the Director to help me to build a computer
        Director director = new Director();
        //The director need call a builder to build a computer
        IComputerBuilder builder = new ComputerBuilder();
        //build a computer for me.
        com.rory.designpattern.builder.Computer computer = director.constructComputer(builder);
        //I'll check the computer configuration
        computer.showConfig();
    }

    @Test
    public void testEvent() {
        EventPublisher publisher = new EventPublisher();
        AddEventListener addEventListener = new AddEventListener();
        DelEventListener delEventListener = new DelEventListener();
        publisher.addListener(addEventListener);
        publisher.addListener(delEventListener);

        publisher.publishEvent(new AddEvent());
    }
}
