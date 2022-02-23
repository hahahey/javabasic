package com.hahahey.Algorithm.car;


public abstract class Car {
    private String brand;
    private MoveStrategy moveStrategy;

    public Car(String brand, MoveStrategy moveStrategy) {
        this.brand = brand;
        this.moveStrategy = moveStrategy;
    }

    public void setMoveStrategy(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void move(){
        System.out.println(brand);
        moveStrategy.move();
    }
}
