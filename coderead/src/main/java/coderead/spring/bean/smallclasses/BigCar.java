package coderead.spring.bean.smallclasses;

import coderead.spring.myannotation.TimeCount;
import lombok.ToString;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-09 18:22
 **/
@ToString
public class BigCar implements Car {
    private String name;
    private int price;

    public BigCar() {
    }

    public BigCar(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @TimeCount
    @Override
    public void printInfo() {
        System.out.println("name : " + name + " price: " + price + "$");
    }
}
