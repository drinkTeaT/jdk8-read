package object;

/**
 * description：null
 * date：2019/9/9
 * Author：tacbin
 **/
public class ReadObject {
    static Greet greet = new Greet();

    public static void main(String[] args) {
        ObjectThreadMethod.objNotify();
        ObjectThreadMethod.objWait();
    }

    /**
     * Object线程的方法wait 和 notify.
     * 使用wait或notify必须在其对象锁里<br/>
     * wait后会释放当前锁,线程wait后被唤醒会重新去竞争锁<br/>
     * notify会随机选一个唤醒，notifyall会唤醒全部
     */
    final static class ObjectThreadMethod {
        /*** 线程等待 */
        static void objWait() {
            synchronized (greet) {
                try {
                    System.out.println("wait..");
                    greet.wait();
                    System.out.printf(greet.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /*** 唤醒线程 */
        static void objNotify() {
            Thread thread = new Thread(() -> {
                synchronized (greet) {
                    try {
                        Thread.sleep(1000);
                        greet.notify();
                        System.out.println("唤醒他了");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

}

class Greet {
    @Override
    public String toString() {
        return "觉醒了, 是否重新获得了锁 " + Thread.holdsLock(this);
    }
}
