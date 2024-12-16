public class ThreadExample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            while (true) {
                System.out.println("BMSCE"); 
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();

        Thread thread2 = new Thread(()->{
            while (true) {
                System.out.println("CSE"); 
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }    
}
