package Agenda.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String nomeEvento;
    private LocalDateTime dataHora;
    DiaDaSemana diaDaSemana;

    private static final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Evento(String nomeEvento, LocalDateTime dataHora, DiaDaSemana diaDaSemana) {
        this.nomeEvento = nomeEvento;
        this.dataHora = dataHora;
        this.diaDaSemana = diaDaSemana;
    }

    public void exibirEvento(){
        System.out.println("\n====== Detalhes do evento! ======");
        System.out.println("Nome do Evento: " + nomeEvento +"\nData e hora: " + dataHora.format(formatador) + "\nDia da semana: " + diaDaSemana);
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }
}
