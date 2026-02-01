import Agenda.entities.DiaDaSemana;
import Agenda.entities.Evento;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class AgendaMain {
    public static void main(String[] args){

        DiaDaSemana diaDaSemana = DiaDaSemana.DOMINGO;
        LocalDateTime hoje = LocalDateTime.now();
        Evento eventoHoje = new Evento("Festa",hoje,diaDaSemana);

        eventoHoje.exibirEvento();

        LocalDateTime dataAtualizada = hoje.plusDays(5);
        eventoHoje.setDataHora(dataAtualizada);

        eventoHoje.setDiaDaSemana(DiaDaSemana.SEXTA);

        System.out.println("\n==== Evento Atualizado(Data e Dia) =====");
        eventoHoje.exibirEvento();

        ZoneId zoneSP = ZoneId.of("America/Sao_Paulo");
        ZonedDateTime fusoSP = dataAtualizada.atZone(zoneSP);

        ZoneId zoneGMT = ZoneId.of("GMT");
        ZonedDateTime fusoGMT = fusoSP.withZoneSameInstant(zoneGMT);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("\n== Horario do evento no fuso de SP e GMT ==");
        System.out.println("São Paulo: " + fusoSP.format(formatador));
        System.out.println("GMT: " + fusoGMT.format(formatador));

    }
}
