public class ContadorSemParametro extends Thread implements Contavel{
    public ContadorSemParametro(){}

    public void run(){
        for(int i = 0; i <= 5; i++){
            System.out.println("Contador " + getName() + ", Contagem: " + i);
        }
    }
}