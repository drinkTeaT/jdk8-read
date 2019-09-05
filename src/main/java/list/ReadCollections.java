package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadCollections {
    private static List<Integer> nums = new ArrayList<>();

    static {
        nums.add(23);
        nums.add(32);
        nums.add(4);
        nums.add(44);
        nums.add(65);
    }

    public static void main(String[] args) {
        ReadCollections.CollectionSort collectionSort = new ReadCollections.CollectionSort();
        collectionSort.binarySearch();
        collectionSort.sortList();
    }

    static class CollectionSort {
        /**
         * 走Arrays.sort方法
         */
        void sortList() {
            Collections.sort(nums);
            System.out.println(nums);
        }

        /**
         * 二分遍历找元素的下标,列表一定得有序。第三个参数貌似没什么用
         */
        void binarySearch() {
            int value = Collections.binarySearch(nums, 23, null);
            System.out.println(value);
            int value1 = Collections.binarySearch(nums, 23, Integer::compareTo);
            System.out.println(value1);
        }
    }
}


