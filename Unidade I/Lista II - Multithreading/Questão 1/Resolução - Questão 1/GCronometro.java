import java.util.Scanner;

public class GCronometro extends Thread {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int op;                                             //Operação a ser Realizada

        int qtdcron = 0;                                    //Quantidade inicial de Thread de cronometragem
        final int MAX = 10;                                 //Quantidade finaal de Thread de cronometragem
        Cronometro[] cronometro = new Cronometro[MAX];      //Array de Threads que recebe a quantidade maxima como tamanho

        //Menu de Operações
        do {
            System.out.println("----------------  MENU  ----------------");
            System.out.println("-  1. Iniciar nova Cronometragem       -");
            System.out.println("-  2. Consultar Cronometro             -");
            System.out.println("-  3. Consultar todos os Cronometros   -");
            System.out.println("-  4. Encerrar                         -");
            System.out.println("----------------------------------------");
            System.out.print("Digite o numero referente a operacao que voce deseja (1-4): ");
            op = s.nextInt();
            System.out.println();

            //Lógica das Operações
            switch (op) {
                case 1:
                    if (qtdcron == MAX) {
                        System.out.println("Não é possível iniciar outro cronômetro. O número máximo de cronômetros (10) já foi atingido.");
                    } else {
                        Cronometro cron = new Cronometro(); //Instanciando uma nova Thread para cronometragem

                        cronometro[qtdcron] = cron;         //Armazenando o cronômetro ativo no array
                        qtdcron++;                          //Atualizando a quantidade de cronômetros ativos

                        cron.setName("Contador " + cron);   //Nomeando a cronometragem
                        cron.start();                       //Startando a Thread
                    }
                    break;
                case 2:
                    if (qtdcron == 0) {
                        System.out.println("Não há cronometros funcionando.");
                    } else {
                        System.out.print("Existem " + qtdcron + " cronometros funcionando. Qual cronometro você deseja consultar (1-" + qtdcron + ")? ");
                        int ncron = s.nextInt();
                        System.out.println();

                        if (ncron == 0 || ncron > qtdcron) {
                            System.out.println("Cronometro " + ncron + " não existe.");
                        } else {
                            System.out.println("Cronometro " + ncron + ", Contagem: " + cronometro[ncron - 1].getContador());
                        }
                    }
                    break;
                case 3:
                    if(qtdcron == 0){
                        System.out.println("Não há cronometros funcionando.");
                    } else {
                        for(int i = 0; i < qtdcron; i++){
                            System.out.println("Contador " + (i + 1) + ", Contagem: " + cronometro[i].getContador());
                        }
                    }
                    break;
            }
        } while (op != 4);
        s.close();
    }
}
