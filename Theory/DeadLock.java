package Theory;

public class DeadLock {
    String s1 = "Tirth ";
    String s2 = "Jani ";
    Thread t1 = new Thread(){
        public void run(){
            while (true){
                synchronized (s1){
                    System.out.println("Lock applied by "+Thread.currentThread()
                            .getName()+" on s1");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {}
                    synchronized (s2){
                        System.out.println(s1+s2);
                    }
                }
            }
        }
    };
    Thread t2 = new Thread(){
        public void run(){
            while (true){
                synchronized (s2){
                    System.out.println("Lock applied by "+Thread.currentThread().getName()+" on s2");
                    System.out.println("Trying to get s1");
                    synchronized (s1){
                        System.out.println(s1+s2);
                    }
                }
            }
        }
    };
    public static void main(String[] args) throws Exception {
        DeadLock d1 = new DeadLock();
        d1.t1.start();
        d1.t2.start();
    }
}
