class MyThread1 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Good Morning");
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Welcome");

            // try {
            //     Thread.sleep(1);
            // } catch (Exception e) {
            //     System.out.println(e);
            // }
        }
    }
}

class Problem1 {
    public static void main(String args[]) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.setPriority(6);
        t2.setPriority(9);
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        t1.start();
        t2.start();
    }
}
