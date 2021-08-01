package myh;

public class Threads {
    private static volatile int signal = 1;

    static class ThreadA implements Runnable {
        @Override
        public void run() {

            while (signal <= 120) {
                if (signal % 3 == 0) {
                    System.out.println("ThreadA:" + signal);
                    synchronized (this) {
                        signal++;
                    }
                }
            }
        }
    }
}
