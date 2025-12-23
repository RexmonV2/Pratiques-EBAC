import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args){
        Scanner LeitorConsole = new Scanner(System.in);

        System.out.println("Digite o tamanho do vetor: ");
        int tamanhoVetor = LeitorConsole.nextInt();
        int[] vetorDoUsuario = new int[tamanhoVetor];

        System.out.println("\nAgora digite o valor para cada posição do vetor!\n");
        for (int i = 0; i < tamanhoVetor; i++){
            System.out.println("Digite o valor da posição " + i + " do seu vetor: ");
            vetorDoUsuario[i] = LeitorConsole.nextInt();
        }

        System.out.println("\nSeu vetor:");
        exibirVetor(vetorDoUsuario);

        processarVetor(vetorDoUsuario);
        System.out.println("\nSeu vetor depois de processado: ");
        exibirVetor(vetorDoUsuario);

    }
    // Modulo para exibir um veto de inteiros
    private static void exibirVetor(int[] vetorDoUsuario){
        for(int i = 0; i <vetorDoUsuario.length; i++){
            System.out.println("Posição " + i + " Do vetor: " + vetorDoUsuario[i]);
        }
    }
    // Modulo para processar o vetor
    private static void processarVetor(int[] vetorDoUsuario){
        for (int i = 0; i < vetorDoUsuario.length; i++){

            if (vetorDoUsuario[i] % 2 == 0){
                vetorDoUsuario[i] *= 2;
            } else {
                vetorDoUsuario[i] = (int) Math.pow(vetorDoUsuario[i], 2);
            }
        }
    }
}
