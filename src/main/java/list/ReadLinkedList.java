package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-08 8:24
 **/
public class ReadLinkedList {
    public static void main(String[] args) {

    }

    private static class Sort {
        static List<Integer> numsList = new LinkedList<>();

        static {
            numsList.add(12);
            numsList.add(234);
            numsList.add(1);
            numsList.add(2);
        }

        /**
         * LinkedList自身没有实现排序，通过List的默认方法实现的。
         * 列表转数组，再调用Arrays.sort
         */
        static void sortAlgorithm() {
            numsList.sort(Integer::compareTo);
        }
    }

    private static class Find {
        static void findAlogrithm() {
        }
    }
}
