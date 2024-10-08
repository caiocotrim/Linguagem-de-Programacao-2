public class ContadorParametrizado extends Thread {
    private int espera;

    public ContadorParametrizado(int espera){}

    //Sobrecarga de Construtor
    public ContadorParametrizado(){
        this(3);
    }

    public void run(){
        for(int i = 0; i <= 5; i++){
            System.out.println("Contagem Atual de " + getName() + ": " + i);
            try {
                sleep(this.espera * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
