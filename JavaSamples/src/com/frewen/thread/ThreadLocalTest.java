package com.frewen.thread;

public class ThreadLocalTest {


    public static void main(String[] args) {

        ThreadLocal<Boolean> mBooleanThreadLocal = new ThreadLocal<Boolean>();
        mBooleanThreadLocal.set(true);
        System.out.println("[" + Thread.currentThread().getName() + "]mBooleanThreadLocal=" + mBooleanThreadLocal.get());

        new Thread("Thread#1") {
            @Override
            public void run() {
                mBooleanThreadLocal.set(false);
                System.out.println("[" + Thread.currentThread().getName() + "]mBooleanThreadLocal=" + mBooleanThreadLocal.get());
            }
        }.start();

        new Thread("Thread#2") {
            @Override
            public void run() {
                System.out.println("[" + Thread.currentThread().getName() + "]mBooleanThreadLocal=" + mBooleanThreadLocal.get());
            }
        }.start();

        }


        /**
         *   下面我们来看一下ThreadLocal的set方法。首先获取设置这个Value的当前线程
         *    然后获取当获取当前线程ThreadLocalMap对象
         *    如果当前线程的ThreadLocalMap对象不为null.则以当前的threadlocal对象为key 更新值。
         *    所以每一个ThreadLocal对象都只能存储一个数据
         *    否则创建该线程的ThreadLocalMap
         *     public void set(T value) {
         *         Thread t = Thread.currentThread();
         *         ThreadLocalMap map = getMap(t);
         *         if (map != null)
         *             map.set(this, value);
         *         else
         *             createMap(t, value);
         *     }
         *
         *
         *
         */

    /**
     * Returns the value in the current thread's copy of this
     * thread-local variable.  If the variable has no value for the
     * current thread, it is first initialized to the value returned
     * by an invocation of the {@link #initialValue} method.
     *
     * @return the current thread's value of this thread-local
     *
     * public T get() {
     *   Thread t = Thread.currentThread();
     *   ThreadLocal.ThreadLocalMap map = getMap(t);
     *   if (map != null) {
     *       ThreadLocal.ThreadLocalMap.Entry e = map.getEntry(this);
     *       if (e != null) {
     *           @SuppressWarnings("unchecked")
     *           T result = (T)e.value;
     *           return result;
     *       }
     *   }
     *   return setInitialValue();
     *}
     **/
}
