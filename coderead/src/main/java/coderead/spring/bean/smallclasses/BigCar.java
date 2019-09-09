package coderead.spring.bean.smallclasses;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-09 18:22
 **/
public class BigCar implements Car {
    private String name;
    private int price;

    public BigCar(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void printInfo() {
        System.out.println("name : " + name + " price: " + price + "$");
    }
}
