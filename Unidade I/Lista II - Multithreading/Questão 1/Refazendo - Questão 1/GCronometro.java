/*Crie uma classe utilitária munida de método estático para gerenciamento de 10 (dez) instâncias de classe Cronometro, sendo
admitida 3 (três) operações, a saber: a) instanciação de uma nova instância seguida do início da execução da thread de
cronometragem a ela associada; b) consulta de contagem atual de enésimo cronômetro, entre aqueles já instanciados; e c)
consulta das contagem de todos os cronômetros instanciados. Um esboço do método estático segue-se abaixo.*/

import java.util.Scanner;
public class GCronometro {
    public static void main(String[] args){
        int qtdcron = 0;
        int max = 10;
        int op;

        Cronometro[] cronometro = new Cronometro[max]; //Instanciando um Array do tipo Cronometro que possui o tamanho da variável max (10)
        Scanner s = new Scanner(System.in);

        do { //Faça o menu enquanto a reposta do usuário for diferente de 4
            System.out.println("----------------- MENU ----------------");
            System.out.println("- 1. Iniciar um novo Cronometro       -");
            System.out.println("- 2. Consultar Cronometro             -");
            System.out.println("- 3. Consultar todos os Cronometros   -");
            System.out.println("- 4. Encerrar                         -");
            System.out.println("---------------------------------------");
            System.out.print("Digite o numero correspondente ao que você deseja: ");
            op = s.nextInt();
            System.out.println();

            switch(op){
                case 1:
                    if(qtdcron == max){
                        System.out.println("A quantidade de cronometros já atingiu sua capacidade maxima. " +
                                            "Nao e possível adicionar mais cronometros.");
                    } else {
                        Cronometro crono = new Cronometro(false);

                        cronometro[qtdcron] = crono;
                        qtdcron++;

                        crono.start();
                        System.out.println("Cronometro iniciado.");
                    }
                    break;
                case 2:
                    if(qtdcron == 0){
                        System.out.println("Nao existe cronometro em execucao.");
                    } else if(qtdcron == 1) {
                             System.out.println("Existe " + qtdcron + " cronometro em execucao. ");
                             System.out.println("Cronometro " + qtdcron + ", Contagem: " + cronometro[qtdcron - 1].getContador());
                    } else {
                        System.out.print("Existem " + qtdcron + " cronometros disponiveis. Qual voce deseja consultar (1-" + qtdcron + ")? ");
                        int r = s.nextInt();

                        if(r <= 0 || r > qtdcron){
                            System.out.println("Este cronometro nao esta entre os disponiveis. Por favor, digite um numero valido.");
                        } else {
                            //O array precisa receber o r - 1 pois, tendo em vista que a posição inicial do array é 0,
                            //o numero que o usuario digitar sempre estará 1 posição a frente (por isso o r -1)
                            System.out.println("Cronometro " + r + ", Contagem: " + cronometro[r - 1].getContador());
                        }
                    }
                    break;
                case 3:
                    if(qtdcron == 0){
                        System.out.println("Não ha cronometros em execucao.");
                    } else {
                        for(int i = 0; i < qtdcron; i++){
                            System.out.println("Cronometro " + (i + 1) + ", Contagem " + cronometro[i].getContador());
                        }
                    }
            }

        } while(op != 4); //Se a resposta do usuario for diferente de 4, o menu continuará na tela. Se for 4, encerrará o programa
        s.close();
    }
}
