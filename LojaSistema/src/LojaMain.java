import Loja.Entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LojaMain {

    public static void main(String[] args) {
        ArrayList<Produtos> carrinho = new ArrayList<>();
        Scanner leitorConsole = new Scanner(System.in);

        System.out.println("==== Bem-vindo a Loja ==== \n");
        System.out.println("Compre quantos produtos quiser e quando finalizar e so escolher a opção de finalizar a compra!\n");

        while (true) {
            mostrarMenu();

            int opcao = lerOpcaoValida(leitorConsole);

            if (opcao == 6) break;

            int quantidade = lerQuantidadeValida(leitorConsole);

            adicionarItem(opcao, quantidade, carrinho);
        }

        exibirLista(carrinho);
        double total = calcularTotal(carrinho);
        System.out.printf("Total da compra: R$ %.2f%n", total);

        leitorConsole.close();
    }

    //Modulo para exibir a lista de produtos
    private static void exibirLista(ArrayList<Produtos> lista) {
        if (lista.isEmpty()) {
            System.out.println("Carrinho vazio.");
            return;
        }

        System.out.println("\n=== Sua compra===");
        for (Produtos p : lista) {
            System.out.printf("%s   R$ %.2f%n", p.getNome(), p.getPreco());
        }
        System.out.println("-------------------");
    }

    //modulo para calcular o total
    private static double calcularTotal(ArrayList<Produtos> carrinho){
        double valorTotal = 0;
        for (Produtos p : carrinho) {
            valorTotal += p.getPreco();
        }
        return valorTotal;
    }

    //modulo para adicionar um item a lista
    private static void adicionarItem(int i, int qtd, ArrayList<Produtos> carrinho) {
        if (qtd <= 0) return;

        Produtos produtoEscolhido = null;
        switch (i) {
            case 1:
                produtoEscolhido = new Televisao("Televisão", 1495.0);
                break;
            case 2:
                produtoEscolhido = new Radio("Rádio", 148.0);
                break;
            case 3:
                produtoEscolhido = new VideoGame("VideoGame", 2489.0);
                break;
            case 4:
                produtoEscolhido = new Tablet("Tablet", 864.0);
                break;
            case 5:
                produtoEscolhido = new Celular("Celular", 1268.0);
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        for (int j = 0; j < qtd; j++) {
            carrinho.add(produtoEscolhido);
        }
        System.out.println(qtd + " " +produtoEscolhido.getNome() + " Adicionado com sucesso ao seu carrinho!\n");
    }

    //Mostrar Menu
    private static void mostrarMenu(){
        System.out.println("___ Menu de compras: ___");
        System.out.printf("1 - Televisão    R$ %,.0f%n", 1495.0);
        System.out.printf("2 - Rádio        R$ %,.0f%n", 148.0);
        System.out.printf("3 - Videogame    R$ %,.0f%n", 2489.0);
        System.out.printf("4 - Tablet       R$ %,.0f%n", 864.0);
        System.out.printf("5 - Celular      R$ %,.0f%n", 1268.0);
        System.out.println("6 - Finalizar a compra");
    }

    //modulo para ler a opção do cliente
    private static int lerOpcaoValida(Scanner leitorConsole){
        int i;
        while (true) {
            System.out.print("Escolha: ");
            if (!leitorConsole.hasNextInt()) {
                System.out.println("Digite apenas números!");
                leitorConsole.next();
                continue;
            }
            i = leitorConsole.nextInt();

            if (i == 6)break;

            if (i >= 1 && i <= 6) {
                return i;
            }

            System.out.println("Opção inválida! Escolha entre 1 e 6");
        }
        return i;
    }

    //modulo para ler a quantidade de produtos
    private static int lerQuantidadeValida(Scanner leitorConsole){
        int j;

        do {
            System.out.println("Quantos deste produto deseja adicionar?");
            if (!leitorConsole.hasNextInt()) {
                System.out.println("Digite apenas números!");
                leitorConsole.next();
            }

            j = leitorConsole.nextInt();

            if (j < 0) {
                System.out.println("Opção inválida Escolha um valor de 0 para cima");
            }

        } while (j < 0);

        return j;
    }
}
