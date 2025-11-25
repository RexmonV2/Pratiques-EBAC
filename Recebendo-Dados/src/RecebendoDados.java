import java.util.Scanner;

public class RecebendoDados {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Olá, vamos captar alguns dados!");

        System.out.println("Primeiro digite seu nome completo: ");
        String Nome = scanner.nextLine();

        System.out.println("Agora seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("Sua idade: ");
        int idade = scanner.nextInt();

        System.out.println("Seu Peso; ");
        double peso = scanner.nextDouble();

        System.out.println("Sua altura: ");
        double altura = scanner.nextDouble();

        scanner.nextLine();
        System.out.println("Para finalizar o seu estado civil: ");
        String estadocivil = scanner.nextLine();

        System.out.println("Seu nome é: " + Nome +
                " seu cpf é " + cpf +
                ", você tem " + idade + " anos" +
                " Tem " + peso + " Kilos " +
                altura + "Metros" +
                " E você é " + estadocivil);

    }
}
