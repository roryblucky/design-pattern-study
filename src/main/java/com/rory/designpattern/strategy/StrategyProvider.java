package com.rory.designpattern.strategy;

public class StrategyProvider {
    private IStrategy strategy;

    public StrategyProvider(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void execute(String user) {
        this.strategy.apply(user);
    }
}
