import java.util.Scanner;

public class EstruturasDeRepeticao {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in); // Inicializamos o scanner

        // Damos ola e explicamos o que iremos fazer
        System.out.println("Olá, vamos contar decrescente de n ate 0 e crescente de 0 ate n!\nPrimeiro nos de seu nome: ");
        String nome = sc.nextLine(); //Recebemos o nome

        // Agora pedimos o valor de N
        System.out.println("Agora nos forneça o valor de N:");
        while (!sc.hasNextInt()){ //Utilizamos While para garantir a entrada correta de int
            System.out.println("Entrada incorreta. digite um número inteiro positivo para n:");
            sc.next();
        }
        int n = sc.nextInt(); //Recebemos o valor de n

        sc.close(); // Fechamos o scanner

        decrescente(n); //Apresentamos a algoritmo decrescente
        System.out.println();
        crescente(n); //Apresentamos a algoritmo crescente
        System.out.println();
        tamanhonome(nome, n); //apresentamos o algoritmo para ler o tamanho do nome

    }
    public static void decrescente(int n){

        if (n > 0){
            System.out.println("Decrescente de " + n + " a zero:\n");
            for (int n1 = n; n1 >= 0; n1--) {
                System.out.println("Valor de n é: " + n1);
            }
        } else {
            System.out.println("Você digitou um número menor do que 1. não pode!!!");
        }
    }
    public  static  void crescente(int n){

        if (n > 0){
            System.out.println("crescente de 0 a " + n + ":\n");
            for (int n1 = 0; n1 <= n; n1++) {
                System.out.println("Valor de n é: " + n1);
            }
        } else {
            System.out.println("Você digitou um número menor do que 1. não pode!!!");
        }
    }
    public static void tamanhonome(String nome, int n){
        System.out.println("Se seu nome Tiver mais que 6 letras o mostraremos " + n + " Vezes: \n");

        if (nome.length() > 6){
            for (int n1 = 0; n1 < n; n1++){
                System.out.println(n1 + ": " + nome);
            }
        } else {
            System.out.println(nome);
        }
    }
}
