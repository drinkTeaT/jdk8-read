package serialize;

import java.io.Serializable;

/**
 * @author EDZ
 * @description
 * @date 2020/7/28 16:38
 */
public class JDKJsonSerializableDemo {
    public static void main(String[] args) {

    }
}

class bread implements Serializable {
    private String name;
    private int price;
}

class breadOne implements Serializable {
    private String name;
    private int price;
}
