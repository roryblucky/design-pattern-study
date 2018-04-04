package com.rory.designpattern;

import com.rory.designpattern.adaptor.PowerSocket110VAdaptor;
import com.rory.designpattern.adaptor.PowerSocket220V;
import com.rory.designpattern.adaptor.PowerSocket220VImpl;
import com.rory.designpattern.bridge.CommonMessage;
import com.rory.designpattern.bridge.EmailSender;
import com.rory.designpattern.bridge.SmsSender;
import com.rory.designpattern.bridge.UrgencyMessage;
import com.rory.designpattern.builder.ComputerBuilder;
import com.rory.designpattern.builder.Director;
import com.rory.designpattern.builder.IComputerBuilder;
import com.rory.designpattern.command.Cooker;
import com.rory.designpattern.command.NoodleCommand;
import com.rory.designpattern.command.RiceCommand;
import com.rory.designpattern.command.Waiter;
import com.rory.designpattern.composite.Company;
import com.rory.designpattern.composite.HNACompany;
import com.rory.designpattern.composite.HRDepartment;
import com.rory.designpattern.composite.ITDepartment;
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
import com.rory.designpattern.memento.Emp;
import com.rory.designpattern.memento.EmpSnapshot;
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
import com.rory.designpattern.reponsechain.Boss;
import com.rory.designpattern.reponsechain.ProjectLeader;
import com.rory.designpattern.reponsechain.TeamLeader;
import com.rory.designpattern.singleton.Singleton;
import com.rory.designpattern.strategy.NormalStrategy;
import com.rory.designpattern.strategy.SimpleStrategy;
import com.rory.designpattern.strategy.StrategyProvider;
import com.rory.designpattern.template.ChineseSpeaker;
import com.rory.designpattern.visitor.*;
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

    @Test
    public void testMemento() {
        Emp emp = new Emp();
        emp.setName("Rory");
        emp.setMoney("100W");
        EmpSnapshot snapshot = emp.createSnapShot();
        System.out.println(emp);
        emp.setMoney("10W");
        System.out.println(emp);
        emp.recovery(snapshot);
        System.out.println(emp);

    }

    @Test
    public void testComposite() {
        Company company = new HNACompany("HNA");
        ITDepartment itDepartment = new ITDepartment("IT");
        HRDepartment hrDepartment = new HRDepartment("HR");
        company.add(itDepartment);
        company.add(hrDepartment);
        company.disPlay(1);
    }

    @Test
    public void testBridge() {
        CommonMessage commonMessage = new CommonMessage("msg", "Rory");
        SmsSender smsSender = new SmsSender(commonMessage);
        smsSender.send();

        UrgencyMessage urgencyMessage = new UrgencyMessage("msg1", "Lu");
        EmailSender emailSender = new EmailSender(urgencyMessage);
        emailSender.send();

    }

    @Test
    public void testCommand() {
        Waiter waiter = new Waiter();
        Cooker cooker = new Cooker();
        NoodleCommand noodleCommand = new NoodleCommand(cooker);
        RiceCommand riceCommand = new RiceCommand(cooker);

        waiter.addCommand(noodleCommand);
        waiter.addCommand(riceCommand);

        waiter.placeOrder();
    }

    @Test
    public void testResponseChain() {
        ProjectLeader projectLeader = new ProjectLeader();
        TeamLeader teamLeader = new TeamLeader();
        Boss boss = new Boss();

        projectLeader.setManager(teamLeader).setManager(boss);

        projectLeader.askForLeave(10);
    }

    /**
     * 同一个药方，可以在药方拿药，也可以在医院拿药。
     * 数据结构没变，但可以被多个对象访问
     */
    @Test
    public void testVisitor() {
        //构造处方
        Prescription prescription = new Prescription();
        prescription.addMedicine(new MedicineA("阿莫西林", 23.00));
        prescription.addMedicine(new MedicineB("抗病毒冲剂", 20.00));

        Visitor hospitalVisitor = new HospitalVisitor("医院");
        Visitor pharmacyVisitor = new PharmacyVisitor("药房");

        //医院拿药
        hospitalVisitor.buyMedicines(prescription);

        //药房拿药
        pharmacyVisitor.buyMedicines(prescription);

    }
}
