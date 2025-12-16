import java.util.Scanner;

public class TabuadaEMenu {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int decisao = 0, base;
        String frase = "";

        System.out.println("Ola vamos calcular a tabuada!\nQual numero você deseja que seja calculado a tabuada: ");
        base = sc.nextInt();

        tabuada(base);
        menu(frase,decisao);

    }
    public static void tabuada(int base){
        int i = 1, resultado;

        while (i <= 10){
            resultado = base * i;
            System.out.println(base + " X " + i + ": " + resultado);
            i++;
        }
    }
    public static void menu(String frase, int decisao){
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Deseja continuar?\n1: Sim\n2: Não");
            decisao = sc.nextInt();

            if (decisao == 1){
                sc.nextLine();
                System.out.println("Por favor digite uma frase ou palavra: ");
                frase = sc.nextLine();
                System.out.println("\nA frase digitada foi: " + frase + "\n");

            } else if (decisao != 2){
                decisao = 1;
                System.out.println("\nA opção digitada foi inválida!\n");
                continue;
            }
        } while (decisao == 1);

        System.out.println("\nObrigado por utilizar o nosso sistema, espero que tenha gostado.");
    }
}
