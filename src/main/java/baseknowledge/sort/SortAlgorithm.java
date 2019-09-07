package baseknowledge.sort;

import java.util.Arrays;

/**
 * Description: 常见的排序算法
 * Author: tacbin
 * Date: 2019-09-06 19:03
 **/
public class SortAlgorithm {
    public static void main(String[] args) {
        // 冒泡排序
        SortAlgorithm.EasySortAlgorithm.bubbleSort();
        // 选择排序
        SortAlgorithm.EasySortAlgorithm.selectionSort();
        // 插入排序
        SortAlgorithm.EasySortAlgorithm.insertSort();
        // 归并排序
        int[] nums = {10, 2, 93, 4, 7, 828, 5, 6, 72, 0, 8, 14};
        SortAlgorithm.AdvancedSort.mergeSort(nums, 0, nums.length - 1);
        SortUtil.showSortedResult("归并排序", nums);
    }

    /**
     * 简单的排序算法：冒泡，选择，插入排序
     */
    static class EasySortAlgorithm {
        /**
         * 冒泡排序
         * 特点：左起开始比较移动，将最大或最小的移动到最后侧。再从左起，移动到倒数第二个，重复步骤。
         * 复杂度:n^2 交换次数为 n^2
         */
        static void bubbleSort() {
            int[] nums = {10, 2, 93, 4, 7, 828, 5, 6, 72, 0, 8, 14};
            for (int i = nums.length - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[j + 1]) {
                        SortUtil.swap(nums, j, j + 1);
                    }
                }
            }
            SortUtil.showSortedResult("冒泡排序", nums);
        }

        /**
         * 选择排序
         * 特点：0号位置不动，接下来的值来竞争这个位置，1号不动，之后的值竞争该位置。直到数组结束。
         * 复杂度: n^2 交换次数变为 n
         */
        static void selectionSort() {
            int[] nums = {10, 2, 93, 4, 7, 828, 5, 6, 72, 0, 8, 14};
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] > nums[j]) {
                        SortUtil.swap(nums, i, j);
                    }
                }
            }
            SortUtil.showSortedResult("选择排序", nums);
        }

        /**
         * 插入排序，简单排序里性能最好的。
         * 特点：第一个元素是已经排序好的，之后的第一个元素为标志元素在左边进行插入操作。直到最后一个标记元素结束.
         * 复杂度：n ~ n^2
         */
        static void insertSort() {
            int[] nums = {10, 2, 93, 4, 7, 828, 5, 6, 72, 0, 8, 14};
            for (int i = 1; i < nums.length; i++) {
                // 此处参考Arrays.sort(Object[]) 插入排序的实现方式
                for (int temp = i; temp > 0 && nums[temp] < nums[temp - 1]; temp--) {
                    SortUtil.swap(nums, temp, temp - 1);
                }
            }
            SortUtil.showSortedResult("插入排序", nums);
        }
    }

    /**
     * 高级排序：归并排序，希尔排序，快速排序，堆排序
     */
    static class AdvancedSort {
        static int[] nums = {10, 2, 93, 4, 7, 828, 5, 6, 72, 0, 8, 14};

        /**
         * 归并排序
         * 特点：先递归分解再合并排序
         * 复杂度：n*logn
         */
        static void mergeSort(int[] dest, int low, int high) {
            int halve = (low + high) >> 1;
            if (low == high) {
                return;
            }
            mergeSort(dest, low, halve);
            mergeSort(dest, halve + 1, high);
            // 合并操作
            int[] src = Arrays.copyOf(nums, nums.length);
            int leftLow = low, rightLow = halve + 1, destLow = low;
            while (leftLow <= halve && rightLow <= high) {
                if (dest[leftLow] > dest[rightLow]) {
                    src[destLow] = dest[rightLow];
                    rightLow++;
                } else {
                    src[destLow] = dest[leftLow];
                    leftLow++;
                }
                destLow++;
            }
            while (leftLow <= halve) {
                src[destLow] = dest[leftLow];
                destLow++;
                leftLow++;
            }
            while (rightLow <= high) {
                src[destLow] = dest[rightLow];
                destLow++;
                rightLow++;
            }
            for (int i = low; i <= high; i++) {
                dest[i] = src[i];
            }
        }
    }

    /**
     * 排序使用的工具类
     */
    static class SortUtil {
        /**
         * 展示排序后的结果
         */
        static void showSortedResult(String sortName, int[] nums) {
            System.out.println(sortName + ":");
            Arrays.stream(nums).forEach(x -> System.out.print(x + " "));
            System.out.println(" ");
        }

        /**
         * 交换值
         */
        static void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
}
