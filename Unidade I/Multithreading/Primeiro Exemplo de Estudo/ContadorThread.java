public class ContadorThread extends Thread {
    
    //Construtor
    public ContadorThread(){}

    public void run(){
        for(int i = 0; i <= 5; i++){
            System.out.println("Contagem Atual de " + getName() + ": " + i);
        }
    }
}
