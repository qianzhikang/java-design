package com.qzk.singleton.lazy.safe;


/**
 * @Description 在多线程中获取线程安全的懒汉式对象
 * @Date 2023-01-13-10-25
 * @Author qianzhikang
 */
public class LazySingletonSafeThread implements Runnable{

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        LazySingletonSafe singleton = LazySingletonSafe.getInstance();
        System.out.println(Thread.currentThread().getName() + ": " + singleton.hashCode());
    }
}
