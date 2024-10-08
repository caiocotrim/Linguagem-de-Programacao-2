public class Threads_2 {
    public static void main (String[] args) {
        
        ContadorParametrizado t2 = new ContadorParametrizado();
        ContadorParametrizado t3 = new ContadorParametrizado();
    
        t2.setName("Contador 1");
        t3.setName("Contador 2");

        t2.start();
        t3.start();
    }
}
