package coderead.spring.bean.smallclasses;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-09 18:23
 **/
public class MiniCar implements Car {
    private String name;
    private int price;

    public MiniCar(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void printInfo() {
        System.out.println("name : " + name + " price: " + price + "$");
    }
}
