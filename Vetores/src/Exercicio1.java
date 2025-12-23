import java.util.Scanner;

public class Exercicio1 {
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

        System.out.println("\nAgora vamos ordenar o seu vetor: ");
        ordenarVetor(vetorDoUsuario);
        exibirvetor(vetorDoUsuario);

        LeitorConsole.nextLine();
        System.out.println("\nAgora vamos ver quantas vogais tem seu nome!\nDigite seu nome: ");
        String nomeDoUsuario = LeitorConsole.nextLine();
        nomeDoUsuario = nomeDoUsuario.toLowerCase();

        char[] nomeLetras = nomeDoUsuario.toCharArray();
        int contador = 0;

        contadorDeVogais(nomeLetras, contador);

    }
    // Modulo para exibir um veto de inteiros
    private static void exibirvetor(int[] vetorDoUsuario){
        for(int i = 0; i <vetorDoUsuario.length; i++){
            System.out.println("Posição " + i + " Do vetor: " + vetorDoUsuario[i]);
        }
    }
    // Modulo para ordenar um vetor de inteiros de maneira crescente
    private static void ordenarVetor(int[] vetorDoUsuario){
        for (int i = 0; i < vetorDoUsuario.length; i++){
            for (int j = i; j < vetorDoUsuario.length; j++){
                if (vetorDoUsuario[j] < vetorDoUsuario[i]){

                    int aux = vetorDoUsuario[i];
                    vetorDoUsuario[i] = vetorDoUsuario[j];
                    vetorDoUsuario[j] = aux;
                }
            }
        }
    }
    // Modulo para contar vogais
    private static void contadorDeVogais(char[] nomeLetras,int contador){
        String vogais = "aeiou";
        for (int i = 0; i < nomeLetras.length; i++){
            if (vogais.contains(String.valueOf(nomeLetras[i]))){
                contador++;
            }
        }
        System.out.println("\nO seu nome contém " + contador + " vogais!");
    }
}
