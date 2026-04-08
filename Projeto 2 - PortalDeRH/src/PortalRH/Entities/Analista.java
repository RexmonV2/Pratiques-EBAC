package PortalRH.Entities;

import java.util.ArrayList;

public class Analista extends Funcionario {
    public Analista(Integer id, String nome) {
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
