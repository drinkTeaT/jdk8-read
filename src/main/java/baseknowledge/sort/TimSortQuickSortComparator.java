package baseknowledge.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * description：tim排序和快排速度测试
 * date：2019/9/18
 * Author：tacbin
 **/
public class TimSortQuickSortComparator {
    public static void main(String[] args) {
        int count = 10000;
        int[] source = ComparatorUtil.arrayGenerator(count);
        long start = System.nanoTime();
        Arrays.sort(source);
        System.out.println("快排基本类型 " + (System.nanoTime() - start));
        Integer[] integers = ComparatorUtil.boxArray(source);
        start = System.nanoTime();
        Arrays.sort(integers);
        System.out.println("归并对象 " + (System.nanoTime() - start));
    }

    private static class ComparatorUtil {
        /**
         * 产生随机数
         *
         * @param count 随机数的数量
         */
        public static int[] arrayGenerator(int count) {
            int[] result = new int[count];
            for (int i = 0; i < count; i++) {
                Random random = new Random(1000);//指定种子数字
                int i2 = random.nextInt(100);
                result[i] = i2;
            }
            return result;
        }

        /**
         * 原始数组->装箱数组
         *
         * @param source 原始数组
         * @return 装箱数组
         */
        public static Integer[] boxArray(int[] source) {
            Integer[] result = Arrays.stream(source).boxed().toArray(Integer[]::new);
            return result;
        }
    }
}

