import ProvasAlunos.entity.Aluno;

import java.util.Scanner;

public class SistemaAlunos {
    public static void main(String[] args){
        Scanner leitorConsole = new Scanner(System.in);

        int qtdAlunos;
        int qtdNotas;

        System.out.println("Olá, vamos adicionar as notas dos alunos e fazer média!");
        System.out.println("Digite a quantidade de alunos: ");
        qtdAlunos = leitorConsole.nextInt();
        System.out.println("Quantas notas deseja adicionar para cada aluno?");
        qtdNotas = leitorConsole.nextInt();

        Aluno[] turma = new Aluno[qtdAlunos];

        for (int i = 0; i < qtdAlunos; i++) {
            leitorConsole.nextLine();
            double[] notasTemp = new double[qtdNotas];

            System.out.println("Qual o nome do aluno " + (i + 1) + " ?");
            String nome = leitorConsole.nextLine();
            System.out.println("Agora vamos adicionar as notas do aluno " + (i + 1) + " (As notas tem que ser maiores que 0 e menores que 10)");

            for (int j = 0; j < qtdNotas; j++) {
                do {
                    System.out.println("Adione a nota " + (j + 1) + " do aluno " + (i + 1));
                    notasTemp[j] = leitorConsole.nextDouble();

                    if (notasTemp[j] < 0 || notasTemp[j] > 10)
                        System.out.println("A nota digitada é inválida!, Por favor digite novamente");

                } while (notasTemp[j] < 0 || notasTemp[j] > 10);
            }
            turma[i] = new Aluno(nome, notasTemp);
        }
        exibirResultados(turma);
        leitorConsole.close();
    }
    // Modulo para exibir os resultados
    public static void exibirResultados(Aluno[] turma){
        System.out.println("\n=== Resultado final dos alunos ===");
        for (Aluno c : turma){
            System.out.println(c.toString());
            System.out.println();
        }
    }
}
