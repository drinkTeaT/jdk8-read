package demo;

import java.util.Random;

/**
 * @author EDZ
 * @description
 * @date 2020/7/29 15:32
 */
public class NumberGenerate {
    public static void main(String[] args) {
        genNumbers(60);
    }

    public static void genNumbers(int count) {
        Random random = new Random();
        while (count-- > 0) {
            int i = random.nextInt(100);
            String v = i < 10 ? "0" + i : i + "";
            System.out.print(v + " ");
            if (count % 10 == 0) {
                System.out.println();
            }
        }
    }
}