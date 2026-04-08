package PortalRH.Entities;

import java.util.ArrayList;

public abstract class Funcionario implements ControleDePonto {

    private String nome;
    private Integer id;
    private ArrayList<RegistroPonto> registros = new ArrayList<>();

    public Funcionario(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public ArrayList<RegistroPonto> getRegistros() {
        return registros;
    }

    public void adicionarRegistro(RegistroPonto registro) {
        this.registros.add(registro);
    }

    public boolean batePonto() {
        return true;
    }

    public int limiteHorasExtras() {
        return 0;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nID Funcionario: " + id + "\nFunção: " + getClass().getSimpleName();
    }
}
