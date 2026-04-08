package PortalRH.application;

import PortalRH.Entities.*;
import PortalRH.exceptions.FuncionarioNaoEncontradoException;
import PortalRH.exceptions.FuncionarioSemPontoException;
import PortalRH.exceptions.HorarioInvalidoException;
import PortalRH.exceptions.LimiteHoraExtraException;
import PortalRH.services.PortalRH;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws HorarioInvalidoException {
        Scanner scanner = new Scanner(System.in);
        PortalRH portal = new PortalRH();

        menuOpcao(scanner, portal);

        scanner.close();
    }

    // metodo do menu de opcoes
    public static void menuOpcao(Scanner scanner, PortalRH portal) throws HorarioInvalidoException {
        System.out.println("==================== Bem-vindo usuario ===================");
        System.out.println("               Vamos utilizar o Portal de RH ");
        System.out.println("==========================================================");

        int opcao;
        boolean continuar = true;

        while (continuar){
            System.out.println("Escolha uma das seguinte opções\n" +
                    "1 - Criar funcionario novo\n" +
                    "2 - Registar o ponto\n" +
                    "3 - Listar Pontos de um Funcionario\n" +
                    "4 - Remover funcionario\n" +
                    "5 - Buscar Funcionario pelo ID\n" +
                    "6 - Sair");

            opcao = validaropcao(scanner, 6);

            switch (opcao){
                case 1:
                    System.out.println("===================================================================\n");
                    cadastrarFuncionario(scanner,portal);
                    System.out.println("\n===================================================================");
                    break;
                case 2:
                    System.out.println("===================================================================\n");
                    registrarPonto(scanner,portal);
                    System.out.println("\n===================================================================");
                    break;
                case 3:
                    System.out.println("===================================================================\n");
                    listarPontosDoFuncionario(scanner,portal);
                    System.out.println("\n===================================================================");
                    break;
                case 4:
                    System.out.println("===================================================================\n");
                    removerFuncionario(scanner,portal);
                    System.out.println("\n===================================================================");
                    break;
                case 5:
                    System.out.println("===================================================================\n");
                    buscarFuncionario(scanner,portal);
                    System.out.println("\n===================================================================");
                    break;
                default:
                    System.out.println("===================================================================\n");
                    continuar = false;
                    System.out.println("Adeus!, Obrigado por usar nosso sistema de Recursos Humanos!");
            }
        }

    }

    private static void buscarFuncionario(Scanner scanner, PortalRH portal) {
        System.out.println("Qual Id do funcionario, para busca-lo");

        Integer idFuncionario = validarId(scanner, portal);

        try {

            portal.buscarFuncionario(idFuncionario);

        } catch (FuncionarioNaoEncontradoException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\nFuncionario ");
        System.out.println(portal.buscarFuncionario(idFuncionario).toString());
    }

    private static void removerFuncionario(Scanner scanner, PortalRH portal) {
        System.out.println("Qual Id do funcionario, para remove-lo");

        Integer idFuncionario = validarId(scanner, portal);

        try {

            portal.buscarFuncionario(idFuncionario);

        } catch (FuncionarioNaoEncontradoException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\nCerteza que deseja remover o funcionario " + portal.buscarFuncionario(idFuncionario).getNome() + " com ID: " + portal.buscarFuncionario(idFuncionario).getId());
        System.out.println("1 - Sim\n2 - Não");

        int opcao = validaropcao(scanner, 2);

        switch (opcao){
            case 1:
                String nomeRemovido = portal.buscarFuncionario(idFuncionario).getNome();
                Integer idRemovido = portal.buscarFuncionario(idFuncionario).getId();

                portal.removerFuncionario(idFuncionario);

                System.out.println("\nO Funcionario " + nomeRemovido + " com ID: " + idRemovido + " foi removido com Sucesso!");
                break;
            default:
                return;
        }

    }

    private static void listarPontosDoFuncionario(Scanner scanner, PortalRH portal) {
        System.out.println("Qual Id do funcionario, para listar os pontos");

        Integer idFuncionario = validarId(scanner, portal);

        try {

            portal.buscarFuncionario(idFuncionario);

        } catch (FuncionarioNaoEncontradoException e){
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\nLista de ponto | " + portal.buscarFuncionario(idFuncionario).getNome() + " ID: " + portal.buscarFuncionario(idFuncionario).getId());
        System.out.println("-----------------------------------------------");

        if (!portal.buscarFuncionario(idFuncionario).batePonto()){
            System.out.println("Esse funcionario não bate ponto!");
        }

        portal.listarPontos(idFuncionario);

        System.out.println("-----------------------------------------------");
    }

    private static void registrarPonto(Scanner scanner, PortalRH portal) throws HorarioInvalidoException {
        System.out.println("Qual Id do funcionario, para registrar o ponto");

        Integer idFuncionario = validarId(scanner, portal);

        try {

            portal.buscarFuncionario(idFuncionario);

        } catch (FuncionarioNaoEncontradoException e){
            System.out.println(e.getMessage());
            return;
        }

        if (!portal.buscarFuncionario(idFuncionario).batePonto()){
            System.out.println("Esse funcionario não pode bater ponto!");
            return;
        }

        LocalDate dataDoPonto = pedirDataValida(scanner);

        LocalTime horaEntrada = pedirHoraValida(scanner ,"hora de ENTRADA (ex: 07:00): ");
        LocalTime horaSaida = pedirHoraValida(scanner, "hora de SAÍDA (ex: 17:00): ");

        try {

            RegistroPonto novoRegistro = new RegistroPonto(dataDoPonto, horaEntrada, horaSaida);
            portal.registrarPonto(idFuncionario, novoRegistro);

        } catch (HorarioInvalidoException | FuncionarioSemPontoException | LimiteHoraExtraException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\nO ponto do funcionario " + portal.buscarFuncionario(idFuncionario).getNome() +
                " Com ID " + portal.buscarFuncionario(idFuncionario).getId() + " foi feito com sucesso!");
    }

    private static LocalTime pedirHoraValida(Scanner scanner, String mensagem) {
        final DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:mm");

        while (true) {

            System.out.print("Digite a " + mensagem);
            String entrada = scanner.nextLine().trim();

            try {

                LocalTime horaValida = LocalTime.parse(entrada, formataHora);
                return horaValida;

            } catch (DateTimeParseException e) {
                System.out.println("Horário inválido. Use o formato HH:mm (de 06:00 a 22:00).");
            }

        }
    }

    private static LocalDate pedirDataValida(Scanner scanner) {
        final DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {

            System.out.print("Digite a data do ponto (dd/MM/yyyy): ");
            String entrada = scanner.nextLine().trim();

            try {

                LocalDate dataValida = LocalDate.parse(entrada, formataData);
                return dataValida;

            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Use o formato dia/mês/ano e garanta que a data existe no calendário.");
            }

        }
    }

    private static void cadastrarFuncionario(Scanner scanner, PortalRH portal) {
        int opcao;
        boolean continuar = true;

        String nomeFuncionario = validarNome(scanner);

        Integer idFuncionario = portal.gerarIdUnico();

        System.out.println("Escolha qual sera a função do funcionario\n" +
                "1 - Gerente\n" +
                "2 - Coordenador\n" +
                "3 - Analista\n" +
                "4 - Assistente\n" +
                "5 - Estagiario\n" +
                "6 - Cancelar Cadastro");
        opcao = validaropcao(scanner, 6);

        switch (opcao){
            case 1:
                Funcionario f1 = new Gerente(idFuncionario, nomeFuncionario);
                portal.cadastrarFuncionarios(f1);
                System.out.println("===================================================================");
                System.out.println("Funcionario criado com sucesso!\n");
                System.out.println(f1);
                break;
            case 2:
                Funcionario f2 = new Coordenador(idFuncionario, nomeFuncionario);
                portal.cadastrarFuncionarios(f2);
                System.out.println("===================================================================");
                System.out.println("Funcionario criado com sucesso!\n");
                System.out.println(f2);
                break;
            case 3:
                Funcionario f3 = new Analista(idFuncionario, nomeFuncionario);
                portal.cadastrarFuncionarios(f3);
                System.out.println("===================================================================");
                System.out.println("Funcionario criado com sucesso!\n");
                System.out.println(f3);
                break;
            case 4:
                Funcionario f4 = new Assistente(idFuncionario, nomeFuncionario);
                portal.cadastrarFuncionarios(f4);
                System.out.println("===================================================================");
                System.out.println("Funcionario criado com sucesso!\n");
                System.out.println(f4);
                break;
            case 5:
                Funcionario f5 = new Estagiario(idFuncionario, nomeFuncionario);
                portal.cadastrarFuncionarios(f5);
                System.out.println("===================================================================");
                System.out.println("Funcionario criado com sucesso!\n");
                System.out.println(f5);
                break;
            default:
                System.out.println("===================================================================\n");
                continuar = false;
                System.out.println("Cadastro do funcionario cancelado!");
        }
    }

    private static String validarNome(Scanner scanner) {
        String nome;

        scanner.nextLine();
        System.out.println("Digite o nome do funcionario:");

        while (true) {

            try {
                System.out.print("Nome: ");
                nome = scanner.nextLine();

                if (nome.isBlank()) {
                    System.out.println("Digite um Nome valido!");
                    scanner.nextLine();
                } else {
                    break;
                }

            } catch (Exception e) {
                System.out.println("Caractere digitado incorreto!, por favor digite um Caractere valido!");
                scanner.nextLine();
            }

        }

        return nome;
    }

    //Valida a opção do menu
    private static int validaropcao(Scanner scanner, int quantiDeOpcao) {
        int valor = 0;

        while (true){

            try{
                System.out.print("Escolha: ");
                valor = scanner.nextInt();
                if (valor <= quantiDeOpcao && valor >= 1){
                    break;
                } else {
                    System.out.println("Por favor escolha uma opção valida!");
                }
            } catch (Exception e) {
                System.out.println("Valor digitado incorreto!, por favor digite um valor valido!");
                scanner.nextLine();
            }

        }
        return valor;
    }

    private static Integer validarId(Scanner scanner, PortalRH portal) {
        scanner.nextLine();
        String entradaDoUsuario;
        Integer idValido;

        while (true){

            try {
                System.out.print("ID: ");
                entradaDoUsuario = scanner.nextLine().trim();

                if(entradaDoUsuario.matches("\\d{6}")){
                    idValido = Integer.parseInt(entradaDoUsuario);
                    break;
                } else {
                    System.out.println("Formato inválido. Você deve digitar exatamente 6 números (ex: 123456).");
                }

            } catch (Exception e) {
                System.out.println("Caractere digitado incorreto!, por favor digite um Caractere valido!");
                scanner.nextLine();
            }

        }

        return idValido;
    }

}
