import java.util.Scanner;

public class CadastroUsuario {
    public static void main(String[] args)  {
        Scanner leitorConsole = new Scanner(System.in);
        String nomeUsuario = "";
        int idadeUsuario = 0;

        System.out.println("========== Bem-Vindo! ==========");
        System.out.println("Vamos cadastrar seu nome e idade!");

        System.out.print("Digite seu nome: ");
        nomeUsuario = leitorConsole.nextLine();

        while (true) {
            System.out.print("Digite sua idade: ");
            if (!leitorConsole.hasNextInt()) {
                System.out.println("Digite apenas números!");
                leitorConsole.next();
                continue;
            }
            idadeUsuario = leitorConsole.nextInt();
            break;
        }

        try {
            cadastrarUsuario(nomeUsuario, idadeUsuario);
        } catch (IdadeInvalidaException e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        } finally {
            System.out.println("Processo de cadastro finalizado.");
        }

        leitorConsole.close();
    }
    //Metodo para validar a idade do usuario
    public static void cadastrarUsuario(String nomeUsuario, int idadeUsuario) throws IdadeInvalidaException{
        if (idadeUsuario < 18) {
            throw new IdadeInvalidaException("O usuario necessita ter mais de 18 anos para se cadastrar!");
        } else if (idadeUsuario >= 18) {
            System.out.println("----------------------------------");
            System.out.println("Nome: " + nomeUsuario + ", Idade: " + idadeUsuario + " | foi cadastrado com sucesso!");
        }
    }
}
