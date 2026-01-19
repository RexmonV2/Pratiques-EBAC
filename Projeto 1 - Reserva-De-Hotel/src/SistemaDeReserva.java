import ReservaHotel.entity.Reserva;

import javax.xml.transform.Source;
import java.util.Scanner;

public class SistemaDeReserva {
    public static void main(String[] args){
        Scanner leitorConsole = new Scanner(System.in);

        Reserva[] lista = new Reserva[10];
        int contador = 0;
        int opcao;

        do {
            System.out.println("==== Escolha uma das seguintes opções ====\n1- Nova Reserva | 2- Listar Reservas | " +
                    "3- Buscar Reserva | 4- Ordenar Reservas | 5- Sair");
            opcao = leitorConsole.nextInt();

            switch (opcao) {
                case 1:
                    if (contador < lista.length) {
                        contador = cadastrarReserva(leitorConsole, lista, contador);
                    } else {
                        System.out.println("\nO Hotel atingiu sua capacidade maxima de 10 Reservas!");
                    }
                    break;
                case 2:
                    listarReservas(lista,contador);
                    break;
                case 3:
                    buscarPorNome(leitorConsole,lista,contador);
                    break;
                case 4:
                    ordenarPorDias(lista,contador);
                    break;
                case 5:
                    System.out.println("Programa finalizado, obrigador por utilizar!");
                    break;
                default:
                    System.out.println("Opção digitada inválida!");
            }
        } while (opcao != 5);
        leitorConsole.close();
    }
    // Modulo para cadastro das reservas
    public static int cadastrarReserva(Scanner leitor, Reserva[] lista, int contador){
        leitor.nextLine();

        System.out.println("Digite no nome do hospede: ");
        String nome = leitor.nextLine();

        System.out.println("Escolha o tipo do quarto\n1- Standard | 2- Luxo | 3- Presidencial");
        String tipoQuarto = "";
        int escolhaQuarto;

        do {
            escolhaQuarto = leitor.nextInt();
            if (escolhaQuarto == 1){
                tipoQuarto = "Standard";
            } else if (escolhaQuarto == 2){
                tipoQuarto = "Luxo";
            } else if (escolhaQuarto == 3) {
                tipoQuarto = "Presidencial";
            } else {
                System.out.println("Opção digitada inválida!, Por favor escolha entre as três opções");
            }
        } while (escolhaQuarto != 1 && escolhaQuarto != 2 && escolhaQuarto != 3);

        int diasEstadia;
        do {
            System.out.println("Quantos dias o hospede deseja permanecer? (Mínimo 1)");
            diasEstadia = leitor.nextInt();
        } while (diasEstadia < 1);

        double valorDiaria;
        do {
            System.out.println("Qual o valor da diaria?");
            valorDiaria = leitor.nextDouble();
        } while (valorDiaria < 1);

        System.out.println("\nValor total: R$" + String.format("%.2f", (valorDiaria * diasEstadia))+"\n");
        System.out.println("Deseja confirmar a reserva?\n1- SIM | 2-NÃO");
        int confirmacao = leitor.nextInt();

        if (confirmacao == 1) {
            lista[contador] = new Reserva(nome, tipoQuarto, diasEstadia, valorDiaria);
            System.out.println("Reserva confirmada!\n");
            return contador+1;
        } else {
            System.out.println("Reserva cancelada.\n");
            return contador;
        }
    }

    // Modulo para demonstrar a lista de reservas
    public static void listarReservas(Reserva[] lista, int contador){
        if (contador == 0) {
            System.out.println("\nErro: Não existem reservas cadastradas para listar.\n");
            return;
        }
        System.out.println("\n======= Lista de Hospedes =======");
        for (int i = 0; i < contador; i++){
            System.out.println((i + 1) + ". " + lista[i].toString());
            System.out.println("-------------------------------------------");
        }
    }

    // Modulo para buscar uma reserva pelo nome
    public static void buscarPorNome(Scanner leitor, Reserva[] lista, int contador){
        leitor.nextLine();
        String nomeBuscado;
        boolean encontrou = false;

        System.out.println("Por qual nome você quer procurar?: ");
        nomeBuscado = leitor.nextLine();

        for (int i = 0; i < contador; i++) {
            if (lista[i].getNomeHospede().toLowerCase().contains(nomeBuscado.toLowerCase())){
                System.out.println("\nHospede encontrado!\n" + lista[i].toString());
                encontrou = true;
            }
        }
        if (encontrou == false){
            System.out.println("\nHóspede não encontrado!\n");
        }
    }

    // Modulo para ordenar as reservas por dias\
    public static void ordenarPorDias(Reserva[] lista, int contador){
        if (contador < 2) {
            System.out.println("\nNão ha reservas suficientes para ordenar.\n");
            return;
        }

        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {

                if (lista[j].getDiasDeEstadia() < lista[j + 1].getDiasDeEstadia()) {

                    Reserva temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }

        System.out.println("\nReservas ordenadas por dias com sucesso!(De forma decrescente)");
        listarReservas(lista, contador);
    }
}
