package PortalRH.Entities;

import java.util.ArrayList;

public class Coordenador extends Funcionario {
    public Coordenador (Integer id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean batePonto() {
        return true;
    }

    @Override
    public int limiteHorasExtras() {
        return 5;
    }
}
