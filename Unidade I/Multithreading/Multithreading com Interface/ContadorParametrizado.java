//É necessário extender a classe Thread para depois implementar outra classe para que não dê erro
public class ContadorParametrizado extends Thread implements Contavel {
    private int espera;
    
    public ContadorParametrizado(int espera){
        this.espera = espera;
    }

    //Sobrecarga de Construtor
    public ContadorParametrizado(){
        this(5);
    }

    public void run(){
        for(int i = 0; i <= 5; i++){
            System.out.println("Contador " + getName() + ", Contagem: " + i);
        } try {
            sleep(espera * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
