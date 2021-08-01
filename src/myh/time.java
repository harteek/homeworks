package myh;

import java.util.Date;

public class time implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        while (true) {
            new Thread(new time()).start();
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        Date d = new Date(System.currentTimeMillis());
        System.out.println(d);
    }
}