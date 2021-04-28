package com.nirvana.travel.patternDesign.factorymethod;

public class CarFactory {
    public Moveable create() {
        System.out.println("a car created!");
        return new Car();
    }
}
