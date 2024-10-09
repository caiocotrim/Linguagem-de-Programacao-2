import java.util.Scanner;

public class SomadorRandomicoUtil {
    public static void main(String[] args){
        char resp;
        Scanner s = new Scanner(System.in);

        final int tam = 4;      //Quantidade de somadores solicitado na questão
        SomadorRandomico[] somadores = new SomadorRandomico[tam];

        //Início da Aplicação
        System.out.print("Informe a quantidade de somadores: ");
        int qtd = s.nextInt();
        System.out.println();

        //Instanciação dos somadores na posição i
        for(int i = 0; i < tam; i++){
            somadores[i] = new SomadorRandomico(qtd);
        }

        //Instanciar e iniciar uma thread para cada somador instanciado anteriormente
        for(int i = 0; i < tam; i++){
            Thread thread = new Thread(somadores[i]);
            thread.start();
        }

        do{
            System.out.print("Consultar Somadores ou Encerrar a aplicacaco (S/E)? ");
            resp = s.next().toLowerCase().charAt(0);
            System.out.println();

            if(resp == 's'){
                int[] somas = new int [tam];

                for(int i = 0; i < tam; i++) {
                    somas[i] = somadores[i].getSoma();
                }

                int imaiorsoma = 0;

                for(int i = 1; i < tam; i++) {
                    if (somas[i] > somas[imaiorsoma]){
                        imaiorsoma = i;
                    }
                    System.out.println("Somadores: ");
                }

                for(int i = 0; i < tam; i++){
                    if(i == tam - 1){
                        System.out.println(" e ");
                    } else if(i != 0){
                        System.out.println(", ");
                    }
                    System.out.println("S" + (i + 1) + " (" + somas[i] + ") ");
                }

            System.out.println("Somador de Maior Valor Momentâneo: S" + (imaiorsoma + 1));
            }
        } while (resp != 'E' && resp != 'e');

        s.close();
        System.exit(0);
    }
}
