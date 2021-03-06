package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description: 读ArrayList的源码
 * Author: tacbin
 * Date: 2019-09-05 22:46
 **/
public class ReadArrayList {
    public static void main(String[] args) {
        Sort.sortAlgorithm();
        Find.findAlogrithm();
    }

    private static class Sort {
        final static List<Integer> numsList = new ArrayList<>();

        static {
            numsList.add(12);
            numsList.add(234);
            numsList.add(1);
            numsList.add(2);
        }

        /**
         * 使用归并排序或tim排序
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
