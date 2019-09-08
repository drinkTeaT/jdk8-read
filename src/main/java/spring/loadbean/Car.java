package spring.loadbean;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-08 12:42
 **/
public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public Car() {
        name = "无牌照";
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car's name : " + name;
    }
}

