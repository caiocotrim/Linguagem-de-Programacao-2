public class Cronometro extends Thread {
    private int contador;
    private boolean verbose;

    public Cronometro(boolean verbose){
        contador = 0;
        this.verbose = verbose;
    }

    public Cronometro(){}

    public int getContador(){
        return contador;
    }

    public boolean isVerbose(){
        return verbose;
    }

    public void setVerbose(boolean verbose){
        this.verbose = verbose;
    }

    public void run(){
        try {
            while (true) {
                sleep(1000);
                contador++;
                if(verbose) {
                    System.out.println("Contador " + getName() + ": " + contador);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
