import java.util.Scanner;

public class Comparandovalores {

    public static void main(String[] args){
        // Iniciamos o scanner para receber os valores
        Scanner scanner = new Scanner(System.in);

        // Damos inicio a captação dos valores
        System.out.println("Vamos comparar valores! \n"+"Entre com o primeiro valor: ");
        int primeirovalor = scanner.nextInt();

        System.out.println("Agora o segundo valor: ");
        int segundovalor = scanner.nextInt();

        // Adicionamos uma variavel que vai receber o valor do maior
        // Usamos uma string para poder também receber texto
        String resultado;

        // Criamos a estruttura de decisão
        if (primeirovalor > segundovalor){
            resultado = String.valueOf(primeirovalor);
        } else if (segundovalor > primeirovalor) {
            resultado = String.valueOf(segundovalor);
        } else {
            resultado = "Ambos valores são iguais!";
        }

        // demonstramos o resultado
        System.out.println("O maior número é: "+ resultado);

        // fechamos o scanner
        scanner.close();
    }
}
