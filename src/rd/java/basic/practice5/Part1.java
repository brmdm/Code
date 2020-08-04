package rd.java.basic.practice5;

public class Part1 {
    static Thread t1 = new Thread(new NameThreadImpl());
    static Thread t2 = new NameThreadExt();

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(2000);
        t2.start();
        Thread.sleep(2000);
    }

    static class NameThreadImpl implements Runnable {
        int count = 0;
        @Override
        public void run() {
            while (count < 4) {
                System.out.println(t1.getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }
    }

    static class NameThreadExt extends Thread {
        int count = 0;
        @Override
        public void run() {
            while (count < 4) {
                System.out.println(t2.getName());
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }
    }


}
