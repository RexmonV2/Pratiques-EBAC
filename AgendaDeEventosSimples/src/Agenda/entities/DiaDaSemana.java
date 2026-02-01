package Agenda.entities;

public enum DiaDaSemana {
    SEGUNDA("Primeiro dia da semana"),
    TERCA("Segundo dia da semana"),
    QUARTA("Terceiro dia da semana"),
    QUINTA("Quarto dia da semana"),
    SEXTA("Quinto dia da semana"),
    SABADO("Sexto dia da semana"),
    DOMINGO("Setimo dia da semana");

    private final String descricao;

    DiaDaSemana(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
