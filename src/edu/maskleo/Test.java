package edu.maskleo;

public class Test {

    public static class PrintHandle {
        boolean flag = false;
    }

    public static void main(String[] args) {
        final PrintHandle handle = new PrintHandle();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 52; ) {
                    synchronized (handle) {
                        if (!handle.flag) {
                            System.out.print(i);
                            System.out.print(i + 1);
                            i += 2;
                            handle.flag = true;
                            try {
                                handle.notify();
                            } catch (Exception e) {
                            }
                        } else {
                            try {
                                handle.wait();
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 65; i <= 64 + 26; ) {
                    synchronized (handle) {
                        if (handle.flag) {
                            System.out.print((char) i);
                            System.out.println("");
                            handle.flag = false;
                            i++;
                            try {
                                handle.notify();
                            } catch (Exception e) {
                            }
                        } else {
                            try {
                                handle.wait();
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
