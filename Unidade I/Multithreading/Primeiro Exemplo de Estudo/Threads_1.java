public class Threads_1 {
    public static void main (String[] args) {
       
        ContadorThread t1 = new ContadorThread();
        ContadorLentoThread t2 = new ContadorLentoThread();

        t1.start();
        t2.start();
    }
}