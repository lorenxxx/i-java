package com.us.improve.concurrent.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName MutexLock
 * @Desciption 互斥锁 不可重入
 * @Author loren
 * @Date 2020/4/25 4:14 PM
 * @Version 1.0
 **/
public class MutexLock {

    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean isHeldExclusively() {
            return super.getState() == 1;
        }

        /**
         * 尝试获取资源，立即返回
         *
         * @param acquires
         * @return 成功则返回true，否则false
         */
        @Override
        public boolean tryAcquire(int acquires) {
            assert acquires == 1;
            if (super.compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        /**
         * 尝试释放资源，立即返回
         *
         * @param releases
         * @return 成功则返回true，否则false
         */
        @Override
        public boolean tryRelease(int releases) {
            assert releases == 1;
            if (super.getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            super.setExclusiveOwnerThread(Thread.currentThread());
            super.setState(0);
            return true;
        }

    }

    /**
     * 真正同步类的实现都依赖继承于AQS的自定义同步器！
     */
    private final Sync sync = new Sync();

    /**
     * 获取资源，即便等待，直到成功才返回
     */
    public void lock() {
        sync.acquire(1);
    }

    /**
     * 尝试获取资源，要求立即返回。成功则为true，失败则为false
     *
     * @return
     */
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    /**
     * 释放资源
     */
    public void unlock() {
        sync.release(1);
    }

    /**
     * 锁是否占有状态
     *
     * @return
     */
    public boolean isLocked() {
        return sync.isHeldExclusively();
    }

}
