package com.hahahey.Algorithm.car;


public class TeslaCar extends Car{
    public TeslaCar(String brand) {
        super(brand,new ElectricStrategy());
    }
}
