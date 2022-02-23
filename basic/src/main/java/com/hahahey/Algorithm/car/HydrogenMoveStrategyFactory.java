package com.hahahey.Algorithm.car;


public class HydrogenMoveStrategyFactory implements MoveStrategyFactory{
    @Override
    public MoveStrategy create() {
        return new HydrogenStrategy();
    }
}
