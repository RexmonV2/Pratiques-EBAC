public class Matriz {
    public static void main(String[] args){
        int[][] matriz = new int[3][3];
        matriz [0][0] = 15;
        matriz [0][1] = 89;
        matriz [0][2] = 45;

        matriz [1][0] = 96;
        matriz [1][1] = 67;
        matriz [1][2] = 89;

        matriz [2][0] = 92;
        matriz [2][1] = 11;
        matriz [2][2] = 52;

        exibirMatriz(matriz);

    }
    public static void exibirMatriz(int[][] matriz){
        for (int[] linha : matriz){
            for (int valorColuna : linha){
                System.out.print(valorColuna + " ");
            }
            System.out.println();
        }
    }
}
