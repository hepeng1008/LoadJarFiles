package testpackage.mapdemo;

import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
    public static void main(String[] args) {

        ReentrantLock lock  = new ReentrantLock();
        lock.tryLock();
    }
}
