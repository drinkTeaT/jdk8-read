package thread.calculation;

import java.util.concurrent.*;

/**
 * description：多线程计算
 * date：2019/9/18
 * Author：tacbin
 **/
public class SimpleCalculation {
    public static final ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Future<Integer> future1 = service.submit(new CalculationTask1());
        Future<Integer> future2 = service.submit(new CalculationTask2());
        System.out.println("线程启动完毕");
        try {
            System.out.println(future1.get() + future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}

/**
 * 计算任务1
 */
class CalculationTask1 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000 * 5);
        System.out.println("任务1计算结束");
        return 1;
    }
}

/**
 * 计算任务2
 */
class CalculationTask2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000 * 1);
        System.out.println("任务2计算结束");
        return 2;
    }
}