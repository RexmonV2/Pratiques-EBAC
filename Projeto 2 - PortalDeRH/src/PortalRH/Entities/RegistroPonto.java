package PortalRH.Entities;

import PortalRH.exceptions.HorarioInvalidoException;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroPonto {

    private LocalDate dia;
    private LocalTime entrada;
    private LocalTime saida;

    public RegistroPonto(LocalDate dia, LocalTime entrada, LocalTime saida) throws HorarioInvalidoException {
        validarHorario(entrada, saida);

        this.dia = dia;
        this.entrada = entrada;
        this.saida = saida;
    }

    public LocalDate getDia() {
        return dia;
    }

    public LocalTime getEntrada() {
        return entrada;
    }

    public LocalTime getSaida() {
        return saida;
    }

    private void validarHorario(LocalTime entrada, LocalTime saida) throws HorarioInvalidoException {

        if (saida.isBefore(entrada) || entrada.equals(saida)){
            throw new HorarioInvalidoException("Horario digitado invalido!, a entrada precisa ser antes da saida");
        }

        if (entrada.isBefore(LocalTime.of(6, 0))){
            throw new HorarioInvalidoException("Horario digitado invalido!, a entrada precisa ser depois das 06:00 da manhã");
        }

        if (saida.isAfter(LocalTime.of(22, 0))){
            throw new HorarioInvalidoException("Horario digitado invalido!, a saida precisa ser antes das 22:00 da noite");
        }

    }

    public long calcularHorasExtras() {
        long horasBrutas = Duration.between(getEntrada(), getSaida()).toHours();

        long horasTrabalhadas = horasBrutas - 1;

        long horasExtras = horasTrabalhadas - 8;

        if (horasExtras < 0){
            return 0;
        }

        return horasExtras;
    }

}
