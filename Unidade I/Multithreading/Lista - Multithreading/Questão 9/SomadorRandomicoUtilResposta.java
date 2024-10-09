import java.util.Scanner;
public class SomadorRandomicoUtilResposta {
    public static void main(String[] args) {
        char resp;
        Scanner scanner = new Scanner(System.in);
        final int TAM = 4; // quantidade de somadores

        // arrays de somadores com capacidade determinada por constante anterior
        SomadorRandomico[] somadores = new SomadorRandomico[TAM];

        // entrada de quantidade de números a serem gerados por cada somador
        System.out.print("Informe Quantidade: ");

        int qtd = scanner.nextInt();

        // instanciação de somadores
        for (int i = 0; i < TAM; i++)
            somadores[i] = new SomadorRandomico(qtd);

        // instanciação de threads a partir de somadores e início de suas execuções
        for (int i = 0; i < TAM; i++) {
            Thread thread = new Thread(somadores[i]);
            thread.start(); // início de execução de thread
        }

        do {
            // entrada de operação a realizar (consulta de somadores ou encerramento)
            System.out.print("\nConsultar Somadores ou Encerrar (S/E)? ");
            resp = scanner.next().toLowerCase().charAt(0);

            if (resp == 's') { // se operação for de consulta....
                int[] somas = new int[TAM];

                // cópia de somas correntes de somadores para array temporário
                for (int i = 0; i < TAM; i++)
                    somas[i] = somadores[i].getSoma();

                // índice (em array) de maior soma até então
                int iMaiorSoma = 0;

                // navegação entre somas a partir de 2o valor mantido em array temporário
                for (int i = 1; i < TAM; i++)
                    if (somas[i] > somas[iMaiorSoma])
                        iMaiorSoma = i;
                System.out.print("Somadores: ");

                // listagem de somas
                for (int i = 0; i < TAM; i++) {// listagem de caracteres de pontuação antes de valor de enésima soma
                    if (i == TAM - 1)
                        System.out.print(" e ");
                    else if (i != 0)
                        System.out.print(", ");
                    System.out.print("S" + (i + 1) + " (" + somas[i] + ")");
                }

                // listagem de índice de maior soma até então
                System.out.println("\nSomador de Maior Valor Momentâneo: S" + (iMaiorSoma + 1));
            }
        } while (resp != 'E' && resp != 'e');

        scanner.close();
        System.exit(0); // encerramento de ambiente de execução Java
    }
}