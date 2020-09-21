package com.hahahey.Algorithm.car;


public class Client {
    public static void main(String[] args) {
//        TeslaCar teslaCar = new TeslaCar("Tesla");
//        teslaCar.move();
//        teslaCar.setMoveStrategy(new GasolineStrategy());
//        teslaCar.move();

        TeslaCar teslaCar = new TeslaCar("Tesla");


        //工厂模式创建
        MoveStrategyFactory moveStrategyFactory = new HydrogenMoveStrategyFactory();
        MoveStrategy moveStrategy = moveStrategyFactory.create();

        teslaCar.setMoveStrategy(moveStrategy);
        teslaCar.move();


    }
}
