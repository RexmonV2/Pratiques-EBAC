package PortalRH.services;

import PortalRH.Entities.Funcionario;
import PortalRH.Entities.RegistroPonto;
import PortalRH.exceptions.FuncionarioNaoEncontradoException;
import PortalRH.exceptions.FuncionarioSemPontoException;
import PortalRH.exceptions.LimiteHoraExtraException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PortalRH {

    private Map<Integer, Funcionario> funcionarios = new HashMap<>();
    private Random gerador = new Random();

    public void cadastrarFuncionarios(Funcionario funcionario){
        funcionarios.put(funcionario.getId(), funcionario);
    }

    public void removerFuncionario(Integer id){

        if (!funcionarios.containsKey(id)) {
            throw new FuncionarioNaoEncontradoException("ID não encontrado!");
        }

        funcionarios.remove(id);
    }

    public Funcionario buscarFuncionario(Integer id){

        if (!funcionarios.containsKey(id)){
            throw new FuncionarioNaoEncontradoException("ID não encontrado!");
        }

        return funcionarios.get(id);
    }

    public void registrarPonto(Integer id, RegistroPonto registro){

        Funcionario funcionario = buscarFuncionario(id);

        if (!funcionario.batePonto()) {
            throw new FuncionarioSemPontoException("Esse funcionario não pode bater ponto!");
        }

        if (registro.calcularHorasExtras() > funcionario.limiteHorasExtras()){
            throw new LimiteHoraExtraException("Esse funcionario so pode fazer até " + funcionario.limiteHorasExtras() + " Horas extras!");
        }

        funcionario.adicionarRegistro(registro);
    }

    public Integer gerarIdUnico(){
        Integer idSorteado;

        do {

            idSorteado = gerador.nextInt(900000) + 100000;

        } while (funcionarios.containsKey(idSorteado));

        return idSorteado;
    }

    public void listarPontos(Integer id){

        for (RegistroPonto registro : funcionarios.get(id).getRegistros()){

            LocalDate dia = registro.getDia();
            LocalTime entrada = registro.getEntrada();
            LocalTime saida = registro.getSaida();

            System.out.println("Dia: " + dia + " | Entrada: " + entrada + "  Saida: " + saida);

        }

    }
}
