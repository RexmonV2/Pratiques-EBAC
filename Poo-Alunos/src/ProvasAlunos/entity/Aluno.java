package ProvasAlunos.entity;

public class Aluno {

    private String nome;
    private double []notas;

    public Aluno (String nome, double []notas){
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double calcularMedia(){
        double media = 0;
        for (int i = 0; i < notas.length; i++) {

            media += notas[i];
        }
        return media / this.notas.length;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " | Média: " + String.format("%.2f", calcularMedia());
    }
}
