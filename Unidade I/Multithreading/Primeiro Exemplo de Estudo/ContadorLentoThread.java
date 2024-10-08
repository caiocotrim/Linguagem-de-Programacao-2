public class ContadorLentoThread extends Thread {
    public ContadorLentoThread(){}

    public void run(){
        for(int i = 0; i <= 5; i++){
            System.out.println("Contador " + getName() + ", Contagem: " + i);
        } try {
            sleep (5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}