import Carro.entity.Carro;

import java.util.Scanner;

public class SistemaFrota {

    public static void main(String[] args){
        Scanner leitorConsole = new Scanner(System.in);

        System.out.println("Olá vamos criar uma lista de carros e adicionar o nome de cada e o valor!\n");
        int quantidadeCarro = menu(leitorConsole);;

        Carro[] frota = new Carro[quantidadeCarro];
        System.out.println("Agora vamos adicionar os carro e seu valor a lista:");

        double somaTotal = cadastroCarro(leitorConsole, frota, quantidadeCarro);
        System.out.println();

        resultado(frota, quantidadeCarro, somaTotal);
        leitorConsole.close();
    }
    //Modulo para retornar a quantidade de carros
    private static int menu(Scanner leitorConsole){
        int qtd;
        do {
            System.out.println("Qual a quantidade de carros que você deseja? (Limite de 50)");
            qtd = leitorConsole.nextInt();
            leitorConsole.nextLine();

            if (qtd < 1 || qtd > 50){
                System.out.println("Valor digitado inválido!\n");
            }
        } while (qtd < 1 || qtd > 50);

        return qtd;
    }
    //Modulo de cadastro
    private static double cadastroCarro(Scanner leitorConsole, Carro[] frota, int quantidadeCarro){
        double soma = 0;
        for (int i = 0; i < quantidadeCarro; i++){
            System.out.println("\n--- Cadastro do Carro " + (i + 1) + " ---");
            System.out.print("Nome: ");
            String nome = leitorConsole.nextLine();
            System.out.print("Preço: ");
            double preco = leitorConsole.nextDouble();
            leitorConsole.nextLine();

            frota[i] = new Carro(nome, preco);

            soma += frota[i].getPreco();
        }
        return soma;
    }
    //Modulo para demonstrar o resultado
    private static void resultado(Carro[] frota, int quantidadeCarro, double somaTotal){
        System.out.println("\n=== Resultado final da lista===");
        for (Carro c : frota){
            System.out.println(c.toString());
            System.out.println();
        }
        System.out.println("Total de carros: " + quantidadeCarro);
        System.out.printf("Soma total dos preços: R$ %.2f\n", somaTotal);
    }
}
