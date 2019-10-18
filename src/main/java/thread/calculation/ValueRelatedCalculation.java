package thread.calculation;

import java.util.concurrent.*;

/**
 * description：线程间进行通信
 * date：2019/9/18
 * Author：tacbin
 **/
public class ValueRelatedCalculation {
    private CountDownLatch latch1 = new CountDownLatch(1);
    private volatile int task1Value;
    public static final ExecutorService service = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        ValueRelatedCalculation calculation = new ValueRelatedCalculation();
        Future<Integer> future1 = service.submit(calculation.new Task1());
        Future<Integer> future2 = service.submit(calculation.new Task2());
        try {
            System.out.println("计算结果：" + future1.get(1,TimeUnit.SECONDS));
            System.out.println("计算结果：" + future2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }

    /**
     * 任务1
     */
    class Task1 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(5 * 1000);
            int result = 8;
            task1Value = result;
            latch1.countDown();
            return result;
        }
    }

    class Task2 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            latch1.await();
            System.out.println("任务1计算完成");
            Thread.sleep(2 * 1000);
            return 2 + task1Value;
        }
    }
}

