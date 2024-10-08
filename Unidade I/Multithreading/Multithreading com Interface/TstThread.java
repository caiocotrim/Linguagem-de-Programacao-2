public class TstThread {
   public static void main (String[] args){
        ContadorParametrizado t1 = new ContadorParametrizado();
        ContadorSemParametro t2 = new ContadorSemParametro();
        /*ContadorParametrizado t3 = new ContadorParametrizado();*/

        t1.setName(" 1");
        t2.setName(" 2");
        /*t3.setName(" 3");*/

        t1.start();
        t2.start();
        /*t3.start();*/
   } 
}
