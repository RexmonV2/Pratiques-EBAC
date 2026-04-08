package PortalRH.Entities;

public class Estagiario extends Funcionario {
    public Estagiario(Integer id, String nome) {
        super(id, nome);
    }

    @Override
    public boolean batePonto() {
        return false;
    }

    @Override
    public int limiteHorasExtras() {
        return 0;
    }
}
