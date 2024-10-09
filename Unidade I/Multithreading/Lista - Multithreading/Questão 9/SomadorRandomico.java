import java.util.Random;

public class SomadorRandomico implements Runnable {
    public static final int max = 100;

    private int soma;
    private int quantidade;

    public SomadorRandomico(int quantidade){
        this.quantidade = quantidade;
    }

    public int getSoma(){
        return soma;
    }

    public void run(){
        Random gerador = new Random();
        for(int i = 0; i < quantidade; i++){
            soma += gerador.nextInt(max);
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
