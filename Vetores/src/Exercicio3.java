import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args){
        Scanner LeitorConsole = new Scanner(System.in);

        System.out.println("Digite um nome para inverter: ");
        String nome = LeitorConsole.nextLine();

        char[] nomeNormal = nome.toCharArray();

        String nomeFinal = inversorDeNomes(nomeNormal);
        System.out.println(nomeFinal);

    }
    // Modulo para inversão de vetores de char (Para inverter nomes)
    private static String inversorDeNomes(char[] nomeNormal){
        for (int i = 0; i < nomeNormal.length / 2; i++){

            int j = nomeNormal.length - 1 - i;

            char variavelAuxiliar = nomeNormal[i];
            nomeNormal[i] = nomeNormal[j];
            nomeNormal[j] = variavelAuxiliar;

        }
        return new String(nomeNormal);
    }
}
