package list;

import java.util.Arrays;

/**
 * Description: null
 * Author: tacbin
 * Date: 2019-09-07 0:25
 **/
public class ReadArrays {
    public static void main(String[] args) {
        ReadArrays.Sort.arraysSort();
    }

    static class Sort {
        static void arraysSort() {
            Integer[] nums = {10, 2, 93, 4, 7, 828, 5, 6, 72, 0, 8, 14};
            Arrays.sort(nums);
            Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
        }
    }

}
