package PortalRH.Entities;

import java.util.ArrayList;

public class Assistente extends Funcionario {
    public Assistente(Integer id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean batePonto() {
        return true;
    }

    @Override
    public int limiteHorasExtras() {
        return 3;
    }
}
